package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.Fornecedor;
import les.scli.repositories.FornecedorRepository;
import les.scli.repositories.ReposicaoRepository;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
  @Autowired
  private FornecedorRepository repositoryFornecedor;

  @Autowired
  private ReposicaoRepository repositoryReposicao;

  public Collection<Fornecedor> findAll() {
    return repositoryFornecedor.findAll();
  }

  public void findById(Integer id) {
    try {
      repositoryFornecedor.findById(id).get();
    } catch (NoSuchElementException e) {
      throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName());
    }
  }

  public Fornecedor insert(Fornecedor fornecedor) {
    fornecedor.setId(null);
    try {
      return repositoryFornecedor.save(fornecedor);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Campo(s) obrigatório(s) do Fornecedor não foi(foram) preenchido(s)");
    }
  }

  public void delete(Integer id) {
    findById(id);
    try {
      repositoryFornecedor.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não é possível excluir este Fornecedor!");
    }
  }

  public Fornecedor update(Fornecedor fornecedor) {
    findById(fornecedor.getId());
    try {
      return repositoryFornecedor.save(fornecedor);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Campo(s) obrigatório(s) do Fornecedor não foi(foram) preenchido(s)");
    }
  }
}
