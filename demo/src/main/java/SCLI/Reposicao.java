package SCLI;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Reposicao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer quantidade;

	private Gerente gerente;

	private Fornecedor fornecedor;

}
