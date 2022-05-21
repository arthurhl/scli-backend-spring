package les.scli.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Reposicao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private Integer quantidade;

	
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private Gerente gerente;

	
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	@OneToMany(mappedBy = "id.reposicao")
	private Collection<ItemReposicao> itens_reposicao = new ArrayList<>();

}
