import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Reposicao {

	private Integer id;

	private Integer quantidade;

	private Gerente gerente;

	private Fornecedor fornecedor;

}
