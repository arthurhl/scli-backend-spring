package les.scli.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les.scli.model.Produto;
import les.scli.repositories.ProdutoRepository;

@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepository repositoryProduto;


  public Collection<Produto> findAll() {
    return repositoryProduto.findAll();
  } 

  public Collection<Produto> listarProdutosDoFornecedor(Integer fornedor_id) {
    return repositoryProduto.listarProdutoDoFornecedor(fornedor_id);
  }
}
