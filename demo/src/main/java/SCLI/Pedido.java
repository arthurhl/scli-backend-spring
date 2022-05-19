import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Pedido implements Serializable {

	private Integer id;

	private String endereco;

	private Double valor;

	private String telefone;

	private Cliente cliente;

}
