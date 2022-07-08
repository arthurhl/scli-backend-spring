package les.scli.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Reposicao extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	@NotNull(message = "Quantidade obrigatória")
	private Integer quantidade;
	
	@CreatedBy
	@NotNull(message = "Gerente_id obrigatório")
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private Gerente gerente;

	@NotNull(message = "Fornecedor_id obrigatório")
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	@NotNull(message = "A reposição deve possui pelo menos um item de Reposicao")
	@OneToMany(mappedBy = "id.reposicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<ItemReposicao> itens = new ArrayList<>();

	@Builder
	public Reposicao(Integer id, Integer quantidade, Gerente gerente, Fornecedor fornecedor) {
		this.id = id;
		this.quantidade = quantidade;
		this.gerente = gerente;
		this.fornecedor = fornecedor;
	}
}

@Data 
@MappedSuperclass
abstract class BaseEntity {
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}