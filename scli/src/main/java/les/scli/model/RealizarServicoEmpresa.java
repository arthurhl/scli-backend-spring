package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class RealizarServicoEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

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
