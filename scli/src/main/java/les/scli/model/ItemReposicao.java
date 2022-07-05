package les.scli.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}) 
public class ItemReposicao implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonIgnore
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
    
    
    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    @JsonIgnore
    public Reposicao getReposicao() {
        return id.getReposicao();
    }

    public void setReposicao(Reposicao reposicao) {
        id.setReposicao(reposicao);
    }
}
