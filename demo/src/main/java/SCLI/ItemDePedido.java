package SCLI;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class ItemDePedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double valor;

	private String[] produto;

}
