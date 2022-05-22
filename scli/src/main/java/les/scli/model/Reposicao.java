package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Reposicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotNull(message = "Quantidade obrigatória")
	private Integer quantidade;

	@NotNull(message = "Gerente_id obrigatório")
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private Gerente gerente;

	@NotNull(message = "Fornecedor_id obrigatório")
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	@NotNull(message = "Reposicao_id obrigatório")
	@OneToMany(mappedBy = "id.reposicao")
	private Collection<ItemReposicao> itens_reposicao = new ArrayList<>();
	
	@Builder
	public Reposicao(Integer id, Integer quantidade, Gerente gerente, Fornecedor fornecedor) {
		this.id = id;
		this.quantidade = quantidade;
		this.gerente = gerente;
		this.fornecedor = fornecedor;
	}
}
