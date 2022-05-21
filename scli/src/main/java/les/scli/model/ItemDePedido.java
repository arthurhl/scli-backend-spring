package les.scli.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class ItemDePedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double valor;

	private String produto;

}
