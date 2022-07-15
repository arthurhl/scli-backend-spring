package les.scli.services;

import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.Orcamento;
import les.scli.repositories.OrcamentoRepository;
import les.scli.services.exceptions.BusinessRuleException;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository repositoryOrcamento;

    public Collection<Orcamento> findAll() {
        return repositoryOrcamento.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryOrcamento.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Orcamento.class.getName());
        }
    }

    public Orcamento insert(Orcamento orcamento) {
        orcamento.setId(null);
        System.out.println(orcamento);
        Integer debito = orcamento.getCliente().getId();

        try {
            // 1. Não pode fazer o orçamento se o cliente estiver em débito;
            Integer count = repositoryOrcamento.findDebitoFuncionario(debito);
            Integer countEmpresa = repositoryOrcamento.findDebitoEmpresa(debito);

            if(count >= 3 || countEmpresa >= 3){
                throw new BusinessRuleException("Cliente em débito!");
            }

            // 2. Só poderá realizar no máximo 3 orçamentos por dia;
            Integer qtdOrcamento = repositoryOrcamento.findQtdOrcamento(debito);
            if(qtdOrcamento >= 3){
                throw new BusinessRuleException("Numero maximo de três orçamentos alcançados!");
            }
            return repositoryOrcamento.save(orcamento);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Orcamento não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryOrcamento.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Orcamento!");
        }
    }

    public Orcamento update(Orcamento Orcamento) {
        findById(Orcamento.getId());
        try {
            return repositoryOrcamento.save(Orcamento);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Orcamento não foi(foram) preenchido(s)");
        }
    }

    public Collection<?> findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(Date dataInicio, Date dataTermino) {
        return repositoryOrcamento.findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(dataInicio, dataTermino);
    }
    
}package les.scli.services;

import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.Orcamento;
import les.scli.repositories.OrcamentoRepository;
import les.scli.services.exceptions.BusinessRuleException;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class OrcamentoService {
    @Autowired
    private OrcamentoRepository repositoryOrcamento;

    public Collection<Orcamento> findAll() {
        return repositoryOrcamento.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryOrcamento.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Orcamento.class.getName());
        }
    }

    public Orcamento insert(Orcamento orcamento) {
        orcamento.setId(null);
        System.out.println(orcamento);
        Integer debito = orcamento.getCliente().getId();

        try {
            // 1. Não pode fazer o orçamento se o cliente estiver em débito;
            Integer count = repositoryOrcamento.findDebitoFuncionario(debito);
            Integer countEmpresa = repositoryOrcamento.findDebitoEmpresa(debito);

            if(count >= 3 || countEmpresa >= 3){
                throw new BusinessRuleException("Cliente em débito!");
            }

            // 2. Só poderá realizar no máximo 3 orçamentos por dia;
            Integer qtdOrcamento = repositoryOrcamento.findQtdOrcamento(debito);
            if(qtdOrcamento >= 3){
                throw new BusinessRuleException("Numero maximo de três orçamentos alcançados!");
            }
            return repositoryOrcamento.save(orcamento);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Orcamento não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryOrcamento.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Orcamento!");
        }
    }

    public Orcamento update(Orcamento Orcamento) {
        findById(Orcamento.getId());
        try {
            return repositoryOrcamento.save(Orcamento);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Orcamento não foi(foram) preenchido(s)");
        }
    }

    public Collection<?> findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(Date dataInicio, Date dataTermino) {
        return repositoryOrcamento.findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(dataInicio, dataTermino);
    }
    
}
