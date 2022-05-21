package les.scli.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private Boolean status;

	@NotNull(message = "Orcamento_id obrigatório")
	@OneToOne
	@JoinColumn(name="orcamento_id")
	private Orcamento orcamento;
}
