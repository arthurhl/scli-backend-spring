package les.scli.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import les.scli.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
  @Transactional(readOnly = true)
    @Query(value = "select pro.* from produto as pro "
    + "left join produto_fornecedor as pf on pf.produto_id = pro.id "
    + "where pf.fornecedor_id = ?1", nativeQuery = true)
    public Collection<Produto> listarProdutoDoFornecedor(Integer fornecedor_id);
    
}
