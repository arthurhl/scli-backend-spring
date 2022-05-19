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
public class Reposicao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer quantidade;

	private Gerente gerente;

	private Fornecedor fornecedor;

}
