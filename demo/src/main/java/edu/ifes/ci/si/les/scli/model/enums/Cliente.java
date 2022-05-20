package edu.ifes.ci.si.les.scli.model.enums;

import java.io.Serializable;
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
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Nome do Ciente deve ser preenchido")
	private String nome;

	@Column(length = 50)
    @NotBlank(message = "CPF do Cliente deve ser preenchido")
    @Size(min = 2, max = 50, message = "CPF do Cliente deve ter entre 2 e 50 letras")
	private String cpf;

	
	private String email;

	private String senha;

	@Column(length = 50)
    @NotBlank(message = "Nome da UF deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome da UF deve ter entre 2 e 50 letras")
	private String uf;

	@Column(length = 50)
    @NotBlank(message = "Nome da cidade deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome da cidade deve ter entre 2 e 50 letras")
	private String cidade;

	@Column(length = 50)
    @NotBlank(message = "Nome do Bairro UF deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome do Bairro  deve ter entre 2 e 50 letras")
	private String bairro;

	@Column(length = 50)
    @NotBlank(message = "Nome da Rua deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome da Rua deve ter entre 2 e 50 letras")
	private String rua;

}
