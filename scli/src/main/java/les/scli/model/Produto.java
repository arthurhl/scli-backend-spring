package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
<<<<<<< HEAD

=======
>>>>>>> acc96e738255eba7dd938b2227382c3b2a4a4500

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
