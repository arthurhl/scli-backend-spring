package les.scli.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemReposicao {
    
    @EmbeddedId
    private ItemReposicaoPK id = new ItemReposicaoPK();

    private Integer quantidade;
}
