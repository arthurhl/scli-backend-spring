package les.scli.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Embeddable
@Data
@EqualsAndHashCode(of = {"reposicao","produto"})
public class ItemReposicaoPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="reposicao_id")
    private Reposicao reposicao;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

}
