package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.Funcionario;
import les.scli.repositories.FuncionarioRepository;
import les.scli.repositories.ReposicaoRepository;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repositoryFuncionario;

    @Autowired
    private ReposicaoRepository repositoryReposicao;

    public Collection<Funcionario> findAll() {
        return repositoryFuncionario.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryFuncionario.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName());
        }
    }

    public Funcionario insert(Funcionario funcionario) {
        funcionario.setId(null);
        try {
            return repositoryFuncionario.save(funcionario);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Funcionario não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryFuncionario.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Funcionario!");
        }
    }

    public Funcionario update(Funcionario funcionario) {
        findById(funcionario.getId());
        try {
            return repositoryFuncionario.save(funcionario);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Funcionario não foi(foram) preenchido(s)");
        }
    }
    
}
