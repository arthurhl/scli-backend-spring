import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Produto implements Serializable {

	private Integer id;

	private String nome;

	private Double valor;

	private Integer quantidade;

	private String descricao;

}
