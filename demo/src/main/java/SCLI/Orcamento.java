package SCLI;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Type;

public class Orcamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Double valor;

	private Date dataInicio;

	private Date dataTermino;

	private String descricao;

	private Cliente cliente;

	private Funcionario funcionario;

	private Servico servico;

}
