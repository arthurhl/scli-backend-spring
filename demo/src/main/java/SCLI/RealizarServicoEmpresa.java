import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class RealizarServicoEmpresa {

	private Integer id;

	private String empresa;

	private Date dataInicio;

	private Boolean status;

	private Servico servico;

	private EmpresaTerceirizada empresaTerceirizada;

}
