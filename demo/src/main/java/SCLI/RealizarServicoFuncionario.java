import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class RealizarServicoFuncionario {

	private Integer id;

	private Date dataInicio;

	private Boolean status;

	private Funcionario funcionario;

	private Servico servico;

}
