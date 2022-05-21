package les.scli.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Produto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private String nome;

	@Column()
	private Double valor;

	@Column()
	private Integer quantidade;

	@Column()
	private String descricao;

	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens_produto_pedido = new HashSet<>();
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemReposicao> itens_reposicao = new HashSet<>();

}
