package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
	@NotBlank(message = "Empresa obrigatória")
	private String empresa;

	@Column()
	@NotBlank(message = "Data obrigatória")
	private Date dataInicio;

	@Column()
	@NotBlank(message = "Status obrigatório")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;

	
	@ManyToOne
	@JoinColumn(name="empresaTerceirizada_id")
	private EmpresaTerceirizada empresaTerceirizada;

}
