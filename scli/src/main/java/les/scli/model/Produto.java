package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

	@NotNull(message = "Produto_id obrigatório")
	@OneToMany(mappedBy = "id.produto")
	private Collection<ItemPedido> itens_produto_pedido = new ArrayList<>();
	
	@NotNull(message = "Produto_id obrigatório")
	@OneToMany(mappedBy = "id.produto")
	private Collection<ItemReposicao> itens_reposicao = new ArrayList<>();
	
	@NotNull(message = "Prudoto_fonercedor obrigatório")
	@ManyToMany
	@JoinTable(name="produto_fornecedor",
		joinColumns = @JoinColumn(name="produto_id"),
		inverseJoinColumns = @JoinColumn(name="fornecedor_id"))
	    private Collection<Fornecedor> fornecedores = new ArrayList<>();	
}
