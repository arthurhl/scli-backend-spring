package les.scli.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ItemReposicao {
    
    @EmbeddedId
    private ItemReposicaoPK id = new ItemReposicaoPK();

    @Column()
    @NotNull(message="Quantidade obrigatório")
    private Integer quantidade;
}
