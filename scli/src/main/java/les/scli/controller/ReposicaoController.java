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

import les.scli.model.Reposicao;
import les.scli.services.ReposicaoService;
import les.scli.services.exceptions.ConstraintException;


// Kaique Nascente
@RestController
@RequestMapping(value="/reposicao")
public class ReposicaoController {
    @Autowired
    private ReposicaoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Reposicao>> findAll() {
        Collection<Reposicao> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Reposicao> insert(@Valid @RequestBody Reposicao reposicao, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        reposicao = service.insert(reposicao);
        return ResponseEntity.ok().body(reposicao);
    } 

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Reposicao> update(@Valid @RequestBody Reposicao reposicao, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        reposicao = service.update(reposicao);
        return ResponseEntity.ok().body(reposicao);
    }

    @RequestMapping(value="/ByPeriod/{beginning}/{end}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Reposicao>> listReplenishmentByPeriod() {
        Collection<Reposicao> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value="/ByProvider", method = RequestMethod.GET)
    public ResponseEntity<Collection<Reposicao>> listReplenishmentByProvider() {
        Collection<Reposicao> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }
}
