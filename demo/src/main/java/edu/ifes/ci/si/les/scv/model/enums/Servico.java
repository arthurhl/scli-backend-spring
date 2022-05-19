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
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Boolean status;

	private Orcamento orcamento;

}
