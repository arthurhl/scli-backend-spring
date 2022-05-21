package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Orcamento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private Double valor;

	@Column()
	private Date dataInicio;

	@Column()
	private Date dataTermino;

	@Column()
	private String descricao;

	@NotNull(message = "Cliente_id obrigatório")
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	
	@NotNull(message = "Funcionario_id obrigatório")
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

}
