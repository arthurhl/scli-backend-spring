package les.scli.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import les.scli.model.Produto;
import les.scli.services.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
  @Autowired
  private ProdutoService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<Produto>> findAll() {
      Collection<Produto> collection = service.findAll();
      return ResponseEntity.ok().body(collection);
  }

  @RequestMapping(value="/{fornecedor_id}", method = RequestMethod.GET)
  public ResponseEntity<Collection<Produto>> listarProodutoDoFornecedor(@PathVariable Integer fornecedor_id) {
      Collection<Produto> collection = service.listarProdutosDoFornecedor(fornecedor_id);
      return ResponseEntity.ok().body(collection);
  }
}
