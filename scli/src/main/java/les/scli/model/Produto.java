package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotBlank(message = "Nome obrigatório")
	private String nome;

	@Column()
	@NotBlank(message = "Valor obrigatório")
	private Double valor;

	@Column()
	@NotBlank(message = "Quantidade obrigatória")
	private Integer quantidade;

	@Column()
	@NotBlank(message = "Descrição obrigatória")
	private String descricao;

	@NotBlank(message = "Pruduto_id obrigatório")
	@OneToMany(mappedBy = "id.produto")
	private Collection<ItemPedido> itens_produto_pedido = new ArrayList<>();
	
	@NotBlank(message = "Pruduto_id obrigatório")
	@OneToMany(mappedBy = "id.produto")
	private Collection<ItemReposicao> itens_reposicao = new ArrayList<>();
	
	@NotBlank(message = "Pruduto_fornecedor obrigatório")
	@ManyToMany
	@JoinTable(name="produto_fornecedor",
		joinColumns = @JoinColumn(name="produto_id"),
		inverseJoinColumns = @JoinColumn(name="fornecedor_id"))
	    private Collection<Fornecedor> fornecedores = new ArrayList<>();	
}
