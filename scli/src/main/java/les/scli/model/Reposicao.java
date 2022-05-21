package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Reposicao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
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

}
