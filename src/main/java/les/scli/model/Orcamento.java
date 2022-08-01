package les.scli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "Data obrigatória")
	private Date dataInicio;

	@Column()
	@NotNull(message = "Data obrigatória")
	private Date dataTermino;

	@Column()
	@NotBlank(message = "Descrição obrigatória")
	private String descricao;

	@Column()
	@Min(value = 1, message = "Valor deve ser maior que zero")
	@NotNull(message = "Valor obrigatório")
	private Double valor;

	@NotNull(message = "Client_id obrigatório")
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@NotNull(message = "Funcionario_id obrigatório")
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

}
