package SCLI;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private String cpf;

	private String uf;

	private String cidade;

	private String bairro;

	private String rua;

	private ItemDeReposicao[] itemDeReposicao;

	private Produto[] produto;

}
