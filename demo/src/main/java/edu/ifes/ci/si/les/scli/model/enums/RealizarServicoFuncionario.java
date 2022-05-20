package edu.ifes.ci.si.les.scli.model.enums;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class RealizarServicoFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date dataInicio;

	private Boolean status;

	private Funcionario funcionario;

	private Servico servico;

}
