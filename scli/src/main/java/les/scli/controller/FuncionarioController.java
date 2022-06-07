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

import les.scli.model.Funcionario;
import les.scli.services.FuncionarioService;
import les.scli.services.exceptions.ConstraintException;

//Rickison Entringer 

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Funcionario>> findAll() {
        Collection<Funcionario> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Funcionario> insert(@Valid @RequestBody Funcionario funcionario, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        funcionario = service.insert(funcionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Funcionario> update(@Valid @RequestBody Funcionario funcionario, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        funcionario = service.update(funcionario);
        return ResponseEntity.ok().body(funcionario);
    }
}
