package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class RealizarServicoFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotNull(message = "Data obrigatória")
	private Date dataInicio;

	@Column()
	@NotNull(message = "Status obrigatório")
	private Boolean status;

	@Column()
	@NotNull(message = "Status obrigatório")
	private Boolean debito;

	@NotNull(message = "Servico_id obrigatório")
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	@NotNull(message = "Funcionario_id obrigatório")
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;
}
