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
public class Reposicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotBlank(message = "Quantidade obrigatória")
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
