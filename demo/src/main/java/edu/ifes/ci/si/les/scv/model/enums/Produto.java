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
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private Double valor;

	private Integer quantidade;

	private String descricao;

}
