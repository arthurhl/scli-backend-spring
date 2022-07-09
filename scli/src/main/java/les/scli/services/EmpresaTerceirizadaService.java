package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.EmpresaTerceirizada;
import les.scli.repositories.EmpresaTerceirizadaRepository;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class EmpresaTerceirizadaService {
    @Autowired
    private EmpresaTerceirizadaRepository repositoryEmpresaTerceirizada;
    
    public Collection<EmpresaTerceirizada> findAll() {
        return repositoryEmpresaTerceirizada.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryEmpresaTerceirizada.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + EmpresaTerceirizada.class.getName());
        }
    }

    public EmpresaTerceirizada insert(EmpresaTerceirizada empresaterceirizada) {
        empresaterceirizada.setId(null);
        try {
            return repositoryEmpresaTerceirizada.save(empresaterceirizada);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Empresa Terceirizada não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryEmpresaTerceirizada.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir esta Empresa Terceirizada!");
        }
    }

    public EmpresaTerceirizada update(EmpresaTerceirizada empresaterceirizada) {
        findById(empresaterceirizada.getId());
        try {
            return repositoryEmpresaTerceirizada.save(empresaterceirizada);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Empresa Terceirizada não foi(foram) preenchido(s)");
        }
    }

}
