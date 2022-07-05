package les.scli.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.scli.model.ItemPedido;
import les.scli.model.Pedido;
import les.scli.repositories.PedidoRepository;
import les.scli.services.exceptions.DataIntegrityException;
import les.scli.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
  @Autowired
  private PedidoRepository repositoryPedido;

  public Collection<Pedido> findAll() {
    return repositoryPedido.findAll();
  }

  public void findById(Integer id) {
    try {
      repositoryPedido.findById(id).get();
    } catch (NoSuchElementException e) {
      throw new ObjectNotFoundException(
          "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName());
    }
  }

  public Pedido insert(Pedido pedido) {
    try {
      pedido.setId(null);

      for (ItemPedido item : pedido.getItens_pedido()) {
        item.setPedido(item.getPedido());
        item.setProduto(item.getProduto());
      }

      return repositoryPedido.save(pedido);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Campo(s) obrigatório(s) do Pedido não foi(foram) preenchido(s)");
    }
  }

  public void delete(Integer id) {
    findById(id);
    try {
      repositoryPedido.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não é possível excluir este Pedido!");
    }
  }

  public Pedido update(Pedido pedido) {
    try {
      findById(pedido.getId());
      for (ItemPedido item : pedido.getItens_pedido()) {
        item.setPedido(item.getPedido());
        item.setProduto(item.getProduto());
      }
      return repositoryPedido.save(pedido);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Campo(s) obrigatório(s) do Pedido não foi(foram) preenchido(s)");
    }
  }
}
