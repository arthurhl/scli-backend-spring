package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class RealizarServicoFuncionario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private Date dataInicio;

	@Column()
	private Boolean status;

	@NotNull(message = "Servico_id obrigatório")
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	@NotNull(message = "Funcionario_id obrigatório")
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;
}
