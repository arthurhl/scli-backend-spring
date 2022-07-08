package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.ItemReposicao;
import les.scli.model.Reposicao;
import les.scli.repositories.ReposicaoRepository;
import les.scli.services.exceptions.BusinessRuleException;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

// Kaique Nascente Januario
@Service
public class ReposicaoService {
    @Autowired
    private ReposicaoRepository repositoryReposicao;

    public Collection<Reposicao> findAll() {
        return repositoryReposicao.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryReposicao.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Reposicao.class.getName());
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Reposicao insert(Reposicao reposicao) {
        try {
            reposicao.setId(null);
           
            verificarRegrasDeNegocio(reposicao);

            for(ItemReposicao item: reposicao.getItens()) {
                item.setReposicao(reposicao);
                item.setProduto(item.getProduto());
            }
            
            return repositoryReposicao.save(reposicao);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Gerente não foi(foram) preenchido(s)");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Integer id) {
        try {
            findById(id);
            repositoryReposicao.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Gerente!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Reposicao update(Reposicao reposicao) {
        try {
            findById(reposicao.getId());
           
            verificarRegrasDeNegocio(reposicao); 
            
            for(ItemReposicao item: reposicao.getItens()) {
                item.setReposicao(reposicao);
                item.setProduto(item.getProduto());
            }

            return repositoryReposicao.save(reposicao);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(e.getMessage());
        }
    }

    public void  verificarRegrasDeNegocio (Reposicao reposicao) { 
        // Regra de Negócio 1: Gerente terá limite de 1.000,00 semanal.
        Double weeklyExpense = repositoryReposicao.weeklyExpenseByManager();

        if(weeklyExpense != null) {
            ItemReposicao item = (ItemReposicao) reposicao.getItens().toArray()[0];
            Double verifyWeeklyExpense = weeklyExpense + (item.getProduto().getValor() * reposicao.getQuantidade());

            if(verifyWeeklyExpense > 1000) {
                throw new BusinessRuleException("Limite semanal excedido por R$"+(verifyWeeklyExpense - 1000)+"!");
            }
        } else {
            ItemReposicao item = (ItemReposicao) reposicao.getItens().toArray()[0];
            Double verifyWeeklyExpense = reposicao.getQuantidade() * item.getProduto().getValor();
            System.out.println(verifyWeeklyExpense);
            if(verifyWeeklyExpense > 1000) {
                throw new BusinessRuleException("Limite semanal excedido por sR$"+(verifyWeeklyExpense - 1000)+"!");
            }
        }

        // Regra de Negócio 2: Gerete poderá comprar 10 produtos por Fornecedor semanal.
        Integer idFornecedor = reposicao.getFornecedor().getId();
        Integer weeklyPurchase = repositoryReposicao.weeklyPurchaseBySupplier(idFornecedor);
        
        if(weeklyPurchase != null) {
            Integer verifyWeeklyPurchase =  weeklyPurchase + reposicao.getQuantidade();
    
            if(verifyWeeklyPurchase > 10) {
                throw new BusinessRuleException("Reposição semanal do fornecedor excedido por "+(verifyWeeklyPurchase - 10)+" itens!");
            }
        } else {
            Integer verifyWeeklyPurchase =  reposicao.getQuantidade();

            if (verifyWeeklyPurchase > 10) {
                throw new BusinessRuleException("Reposição semanal do fornecedor excedido por "+(verifyWeeklyPurchase - 10)+" itens!");
            }
        }
    }
}

