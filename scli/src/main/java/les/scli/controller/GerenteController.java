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

import les.scli.model.Gerente;
import les.scli.services.GerenteService;
import les.scli.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value="/gerente")
public class GerenteController {
    @Autowired
    private GerenteService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Gerente>> findAll() {
        Collection<Gerente> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Gerente> insert(@Valid @RequestBody Gerente gerente, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        gerente = service.insert(gerente);
        return ResponseEntity.ok().body(gerente);
    } 

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Gerente> update(@Valid @RequestBody Gerente gerente, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        gerente = service.update(gerente);
        return ResponseEntity.ok().body(gerente);
    }
}
