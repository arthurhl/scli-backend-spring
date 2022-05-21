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

	private Double valor;

	private Date dataInicio;

	private Date dataTermino;

	private String descricao;

	private Cliente cliente;

	private Funcionario funcionario;

}
