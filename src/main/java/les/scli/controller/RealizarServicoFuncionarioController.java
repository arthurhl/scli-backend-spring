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

import les.scli.model.RealizarServicoFuncionario;
import les.scli.services.RealizarServicoFuncionarioService;
import les.scli.services.exceptions.ConstraintException;

//Victor Reis

@RestController
@RequestMapping(value = "/realizarservicofuncionario")
public class RealizarServicoFuncionarioController {
    @Autowired
    private RealizarServicoFuncionarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<RealizarServicoFuncionario>> findAll() {
        Collection<RealizarServicoFuncionario> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RealizarServicoFuncionario> insert(@Valid @RequestBody RealizarServicoFuncionario RealizarServicoFuncionario,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        RealizarServicoFuncionario = service.insert(RealizarServicoFuncionario);
        return ResponseEntity.ok().body(RealizarServicoFuncionario);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<RealizarServicoFuncionario> update(@Valid @RequestBody RealizarServicoFuncionario RealizarServicoFuncionario,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        RealizarServicoFuncionario = service.update(RealizarServicoFuncionario);
        return ResponseEntity.ok().body(RealizarServicoFuncionario);
    }

}
