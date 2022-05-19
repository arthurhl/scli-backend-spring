import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Servico implements Serializable {

	private Integer id;

	private Boolean status;

	private Orcamento[] orcamento;

	private Orcamento orcamento;

}
