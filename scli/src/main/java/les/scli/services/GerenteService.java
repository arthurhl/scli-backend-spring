package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.Gerente;
import les.scli.repositories.GerenteRepository;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository repositoryGerente;
    
    public Collection<Gerente> findAll() {
        return repositoryGerente.findAll();
    }

    public void findById(Integer id) {
    	try {
        	repositoryGerente.findById(id).get();
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Gerente.class.getName());
        }
    }
    
    public Gerente insert(Gerente gerente) {
        gerente.setId(null);
        try {
        	return repositoryGerente.save(gerente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Gerente não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryGerente.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Gerente!");
        }
    }

    public Gerente update(Gerente gerente) {
        findById(gerente.getId());
        try {
        	return repositoryGerente.save(gerente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Gerente não foi(foram) preenchido(s)");
        }
    }
}
