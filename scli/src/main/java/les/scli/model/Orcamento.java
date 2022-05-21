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
public class Orcamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotBlank(message = "Valor obrigatório")
	private Double valor;

	@Column()
	@NotBlank(message = "Data obrigatória")
	private Date dataInicio;

	@Column()
	@NotBlank(message = "Data obrigatória")
	private Date dataTermino;

	@Column()
	@NotBlank(message = "Descrição obrigatória")
	private String descricao;

	@NotBlank(message = "Client_id obrigatório")
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@NotBlank(message = "Funcionario_id obrigatório")
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

}
