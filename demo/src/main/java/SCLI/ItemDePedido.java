import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class ItemDePedido implements Serializable {

	private Double valor;

	private String[] produto;

}
