package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
	private Collection<ItemPedido> itens_produto_pedido = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.produto")
	private Collection<ItemReposicao> itens_reposicao = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="produto_fornecedor",
		joinColumns = @JoinColumn(name="produto_id"),
		inverseJoinColumns = @JoinColumn(name="fornecedor_id"))
	    private Collection<Fornecedor> fornecedores = new ArrayList<>();	
}
