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

	@Column()
	private Cliente cliente;

	@Column()
	private Funcionario funcionario;

}
