package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class RealizarServicoFuncionario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private Date dataInicio;

	@Column()
	private Boolean status;

	@Column()
	private Funcionario funcionario;

	@Column()
	private Servico servico;

}
