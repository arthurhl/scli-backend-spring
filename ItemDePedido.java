package edu.ifes.ci.si.les.scli.model.enums;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class ItemDePedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double valor;

	private String[] produto;

}
