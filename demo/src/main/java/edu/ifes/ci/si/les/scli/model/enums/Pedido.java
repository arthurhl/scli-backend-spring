package edu.ifes.ci.si.les.scli.model.enums;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String endereco;

	private Double valor;

	private String telefone;

	private Cliente cliente;

}
