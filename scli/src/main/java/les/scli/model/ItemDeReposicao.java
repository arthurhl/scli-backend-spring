package les.scli.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class ItemDeReposicao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer quantidade;

}
