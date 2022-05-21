package les.scli.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class EmpresaTerceirizada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	

	@Column(length = 50)
	@NotBlank(message = "Nome da Empresa Terceirizada deve ser preenchido")
	private String nome;


	@Column(length = 50)
    @NotBlank(message = "CNPJ da Empresa deve ser preenchido")
    @Size(min = 2, max = 50, message = "CNPJ da Empresa deve ter entre 2 e 50 letras")
	private String cnpj;

	@Column(length = 50)
    @NotBlank(message = "Nome da UF deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome da UF deve ter entre 2 e 50 letras")
	private String uf;

    @Column(length = 50)
    @NotBlank(message = "Nome da cidade deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome da cidade deve ter entre 2 e 50 letras")
	private String cidade;

    @Column(length = 50)
    @NotBlank(message = "Nome do bairro deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome do bairro deve ter entre 2 e 50 letras")
	private String bairro;

	@Column(length = 50)
    @NotBlank(message = "Nome da rua deve ser preenchida")
    @Size(min = 2, max = 50, message = "Nome da rua deve ter entre 2 e 50 letras")
	private String rua;

}
