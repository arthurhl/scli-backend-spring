package SCLI;


import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id")
public class RealizarServicoEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String empresa;

	private Date dataInicio;

	private Boolean status;

	private Servico servico;

	private EmpresaTerceirizada empresaTerceirizada;

}
