package SCLI;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private String cpf;

	private String email;

	private String senha;

	private String uf;

	private String cidade;

	private String bairro;

	private String rua;

}
