package les.scli.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String endereco;

	private Double valor;

	private String telefone;

	private Cliente cliente;

}
