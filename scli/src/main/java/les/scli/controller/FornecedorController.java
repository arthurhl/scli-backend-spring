package les.scli.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import les.scli.model.Fornecedor;
import les.scli.services.FornecedorService;
import les.scli.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {
  @Autowired
  private FornecedorService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<Fornecedor>> findAll() {
    Collection<Fornecedor> collection = service.findAll();
    return ResponseEntity.ok().body(collection);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Fornecedor> insert(@Valid @RequestBody Fornecedor fornecedor, BindingResult br) {
    if (br.hasErrors())
      throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
    fornecedor = service.insert(fornecedor);
    return ResponseEntity.ok().body(fornecedor);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<Fornecedor> update(@Valid @RequestBody Fornecedor fornecedor, BindingResult br) {
    if (br.hasErrors())
      throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
    fornecedor = service.update(fornecedor);
    return ResponseEntity.ok().body(fornecedor);
  }
}
