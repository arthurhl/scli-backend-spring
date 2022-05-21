package les.scli.model;

import javax.persistence.*;

@Entity
public class ItemReposicao {
    
    @EmbeddedId
    private ItemReposicaoPK id = new ItemReposicaoPK();

    private Integer quantidade;
}
