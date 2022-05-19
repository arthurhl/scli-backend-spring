import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Fornecedor implements Serializable {

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
