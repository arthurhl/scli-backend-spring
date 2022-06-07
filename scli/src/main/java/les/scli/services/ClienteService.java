package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.Cliente;
import les.scli.repositories.ClienteRepository;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repositoryCliente;

    public Collection<Cliente> findAll() {
        return repositoryCliente.findAll();
    }

    public void findById(Integer id) {
        try {
            repositoryCliente.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
        }
    }

    public Cliente insert(Cliente cliente) {
        cliente.setId(null);
        try {
            return repositoryCliente.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Cliente não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repositoryCliente.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Cliente!");
        }
    }

    public Cliente update(Cliente cliente) {
        findById(cliente.getId());
        try {
            return repositoryCliente.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Cliente não foi(foram) preenchido(s)");
        }
    }
    
}
