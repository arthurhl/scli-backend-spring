package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.ItemReposicao;
import les.scli.model.ItemReposicaoPK;

@Repository
public interface ItemReposicaoRepository extends JpaRepository<ItemReposicao, ItemReposicaoPK> {
    
}
