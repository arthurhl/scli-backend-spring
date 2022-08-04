package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.RealizarServicoFuncionario;
import les.scli.repositories.RealizarServicoFuncionarioRepository;
import les.scli.services.exceptions.BusinessRuleException;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class RealizarServicoFuncionarioService {
    @Autowired
    private RealizarServicoFuncionarioRepository repositoryRealizarServicoFuncionario;

    public Collection<RealizarServicoFuncionario> findAll() {
        return repositoryRealizarServicoFuncionario.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryRealizarServicoFuncionario.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + RealizarServicoFuncionario.class.getName());
        }
    }

    public RealizarServicoFuncionario insert(RealizarServicoFuncionario realizarServicoFuncionario) {
        realizarServicoFuncionario.setId(null);
        System.out.println(realizarServicoFuncionario);
         Integer idFuncionario = realizarServicoFuncionario.getFuncionario().getId();
        try {
            // 1. O funcionario não pode ter 3 serviços vinculado a ele em aberto em aberto,informar ao usuário (será exibida uma mensagem para o usuário);
            Integer count = repositoryRealizarServicoFuncionario.findCountServico(idFuncionario);
            if(count >= 3){
                throw new BusinessRuleException("Numero maximo de três servicos alcançados!");
            }
            // 2. Se um servico ja estiver cadastrado a um funcionario não é possivel cadastrar outro funcionario a este servico;
            Integer idEmpresa = realizarServicoFuncionario.getServico().getId();
            Integer countFeedback = repositoryRealizarServicoFuncionario.findCountFeedback(idEmpresa);
            if (countFeedback == 1) {
                throw new BusinessRuleException("Serviço já cadastrado");
            }
            return repositoryRealizarServicoFuncionario.save(realizarServicoFuncionario);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de realizar serviço empresa não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryRealizarServicoFuncionario.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir esta realização de serviço empresa!");
        }
    }

    public RealizarServicoFuncionario update(RealizarServicoFuncionario RealizarServicoEmpresa) {
        findById(RealizarServicoEmpresa.getId());
        try {
            return repositoryRealizarServicoFuncionario.save(RealizarServicoEmpresa);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de realizar serviço empresa não foi(foram) preenchido(s)");
        }
    }

}
