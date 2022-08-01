package les.scli.controller;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import les.scli.model.Orcamento;
import les.scli.services.OrcamentoService;
import les.scli.services.exceptions.ConstraintException;

//Jonathan Bandeira

@RestController
@RequestMapping(value = "/orcamento")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Orcamento>> findAll() {
        Collection<Orcamento> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Orcamento> insert(@Valid @RequestBody Orcamento Orcamento,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        Orcamento = service.insert(Orcamento);
        return ResponseEntity.ok().body(Orcamento);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Orcamento> update(@Valid @RequestBody Orcamento Orcamento,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        Orcamento = service.update(Orcamento);
        return ResponseEntity.ok().body(Orcamento);
    }

    @RestController
    @RequestMapping(value = "/orcamento")
    public class EmprestimoController {

        @RequestMapping(value = "/findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo/{dataInicio}/{dataTermino}", method = RequestMethod.GET)
        public ResponseEntity<Collection<?>> findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(
                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicio,
                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataTermino) {
            Collection<?> collection = service.findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(
                    dataInicio, 
                    dataTermino);
            return ResponseEntity.ok().body(collection);
        }

    }

}
