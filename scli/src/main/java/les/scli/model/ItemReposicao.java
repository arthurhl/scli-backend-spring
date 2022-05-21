package les.scli.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ItemReposicao {
    
    @EmbeddedId
    private ItemReposicaoPK id = new ItemReposicaoPK();

    @Column()
    @NotNull(message="Quantiade obrigatório")
    private Integer quantidade;
}
