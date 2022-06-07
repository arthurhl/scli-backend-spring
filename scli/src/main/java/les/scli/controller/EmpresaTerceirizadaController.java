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

import les.scli.model.EmpresaTerceirizada;
import les.scli.services.EmpresaTerceirizadaService;
import les.scli.services.exceptions.ConstraintException;

//Victor Reis

@RestController
@RequestMapping(value = "/empresaterceirizada")
public class EmpresaTerceirizadaController {
    @Autowired
    private EmpresaTerceirizadaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<EmpresaTerceirizada>> findAll() {
        Collection<EmpresaTerceirizada> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmpresaTerceirizada> insert(@Valid @RequestBody EmpresaTerceirizada empresaterceirizada,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        empresaterceirizada = service.insert(empresaterceirizada);
        return ResponseEntity.ok().body(empresaterceirizada);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<EmpresaTerceirizada> update(@Valid @RequestBody EmpresaTerceirizada empresaterceirizada,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        empresaterceirizada = service.update(empresaterceirizada);
        return ResponseEntity.ok().body(empresaterceirizada);
    }

}
