package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

	@NotNull(message = "Cliente_id obrigatório")
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@NotNull(message = "Pedido_id obrigatório")
	@OneToMany(mappedBy = "id.pedido")
	private Collection<ItemPedido> itens_produto_pedido  = new ArrayList<>();

}
