package les.scli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}) 
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    
    @Column()
    @NotNull(message="Valor obrigatório")
    private Double valor;

    @Builder
    public ItemPedido(Pedido pedido, Produto produto, Double valor) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.valor = valor;
    }
}