package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

}
