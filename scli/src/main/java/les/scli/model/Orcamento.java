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
public class Orcamento implements Serializable {

	private static final long serialVersionUID = 1L;

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
