package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
@Entity
public class Pedido implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private String endereco;

	@Column()
	private Double valor;

	@Column()
	private String telefone;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Collection<ItemPedido> itens_produto_pedido  = new ArrayList<>();

}
