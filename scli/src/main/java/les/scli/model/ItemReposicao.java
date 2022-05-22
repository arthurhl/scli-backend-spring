package les.scli.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}) 
public class ItemReposicao implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemReposicaoPK id = new ItemReposicaoPK();

    @Column()
    @NotNull(message="Quantidade obrigatório")
    private Integer quantidade;

    @Builder
    public ItemReposicao(Produto produto, Reposicao reposicao, Integer quantidade) {
        this.id.setProduto(produto);
        this.id.setReposicao(reposicao);
        this.quantidade = quantidade;
    }

}
