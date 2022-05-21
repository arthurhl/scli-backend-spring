package les.scli.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Reposicao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private Integer quantidade;

	@Column()
	private Gerente gerente;

	@Column()
	private Fornecedor fornecedor;

	@OneToMany(mappedBy = "id.reposicao")
	private Set<ItemReposicao> itens_reposicao = new HashSet<>();

}
