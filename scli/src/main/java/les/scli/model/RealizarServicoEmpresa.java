package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class RealizarServicoEmpresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private String empresa;

	@Column()
	private Date dataInicio;

	@Column()
	private Boolean status;

	@Column()
	private Servico servico;

	@Column()
	private EmpresaTerceirizada empresaTerceirizada;

}
