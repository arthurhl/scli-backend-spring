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
public class RealizarServicoFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataInicio;

	private Boolean status;

	private Funcionario funcionario;

	private Servico servico;

}
