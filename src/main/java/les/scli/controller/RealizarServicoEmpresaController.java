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

import les.scli.model.RealizarServicoEmpresa;
import les.scli.services.RealizarServicoEmpresaService;
import les.scli.services.exceptions.ConstraintException;

//Victor Reis

@RestController
@RequestMapping(value = "/realizarservicoempresa")
public class RealizarServicoEmpresaController {
    @Autowired
    private RealizarServicoEmpresaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<RealizarServicoEmpresa>> findAll() {
        Collection<RealizarServicoEmpresa> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RealizarServicoEmpresa> insert(@Valid @RequestBody RealizarServicoEmpresa RealizarServicoEmpresa,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        RealizarServicoEmpresa = service.insert(RealizarServicoEmpresa);
        return ResponseEntity.ok().body(RealizarServicoEmpresa);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<RealizarServicoEmpresa> update(@Valid @RequestBody RealizarServicoEmpresa RealizarServicoEmpresa,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        RealizarServicoEmpresa = service.update(RealizarServicoEmpresa);
        return ResponseEntity.ok().body(RealizarServicoEmpresa);
    }
    
    @RequestMapping(value = "/relatorio/{debito}", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findRelatorioEmpresaDebito(@PathVariable boolean debito) {
        Collection<?> relatorioEmpresa = service.findRelatorioEmpresaDebito(debito);
        return ResponseEntity.ok().body(relatorioEmpresa);
    }

}
