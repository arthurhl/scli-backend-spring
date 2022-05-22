package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotBlank(message = "Endereço obrigatório")
	private String endereco;

	@Column()
	@NotNull(message = "Valor obrigatório")
	private Double valor;

	@Column()
	@NotBlank(message = "Telefone obrigatório")
	private String telefone;

	@NotNull(message = "Client_id obrigatório")
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@NotNull(message = "Pedido_id obrigatório")
	@OneToMany(mappedBy = "id.pedido")
	private Collection<ItemPedido> itens_produto_pedido  = new ArrayList<>();
	
	@Builder
	public Pedido(Integer id, String endereco, Double valor, String telefone, Cliente cliente) {
		this.id = id;
		this.endereco = endereco;
		this.valor = valor;
		this.telefone = telefone;
		this.cliente = cliente;
	}
}
