package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.RealizarServicoEmpresa;
import les.scli.repositories.RealizarServicoEmpresaRepository;
import les.scli.services.exceptions.BusinessRuleException;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class RealizarServicoEmpresaService {
    @Autowired
    private RealizarServicoEmpresaRepository repositoryRealizarServicoEmpresa;

    public Collection<RealizarServicoEmpresa> findAll() {
        return repositoryRealizarServicoEmpresa.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryRealizarServicoEmpresa.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + RealizarServicoEmpresa.class.getName());
        }
    }

    public RealizarServicoEmpresa insert(RealizarServicoEmpresa realizarServicoEmpresa) {
        realizarServicoEmpresa.setId(null);
        System.out.println(realizarServicoEmpresa);
        Integer idEmpresa = realizarServicoEmpresa.getEmpresaTerceirizada().getId();
        try {
            // 1. Se a empresa estiver com 3 serviços em aberto, informar ao usuário (será exibida uma mensagem para o usuário);
            Integer count = repositoryRealizarServicoEmpresa.findCountServico(idEmpresa);
            if(count >= 3){
                throw new BusinessRuleException("Numero maximo de três servicos alcançados!");
            }
            // 2. Caso a empresa preste mais de 3 serviços com feedback negativo ficará impossibilitado de receber mais serviços;
            Integer countFeedback = repositoryRealizarServicoEmpresa.findCountFeedback(idEmpresa);
            if (countFeedback >= 3) {
                throw new BusinessRuleException("Numero de Feedbacks negativos alcançado!");
            }
            return repositoryRealizarServicoEmpresa.save(realizarServicoEmpresa);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de realizar serviço empresa não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryRealizarServicoEmpresa.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir esta realização de serviço empresa!");
        }
    }

    public RealizarServicoEmpresa update(RealizarServicoEmpresa RealizarServicoEmpresa) {
        findById(RealizarServicoEmpresa.getId());
        try {
            return repositoryRealizarServicoEmpresa.save(RealizarServicoEmpresa);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de realizar serviço empresa não foi(foram) preenchido(s)");
        }
    }

    public Collection<?> findRelatorioEmpresaDebito(boolean debito) {
        try {
            return repositoryRealizarServicoEmpresa.findRelatorioEmpresaDebito(debito);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Erro ao realizar o relatorio!" + RealizarServicoEmpresa.class.getName());
        }
    }

}
