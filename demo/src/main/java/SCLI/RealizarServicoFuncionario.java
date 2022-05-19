package SCLI;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class RealizarServicoFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date dataInicio;

	private Boolean status;

	private Funcionario funcionario;

	private Servico servico;

}
