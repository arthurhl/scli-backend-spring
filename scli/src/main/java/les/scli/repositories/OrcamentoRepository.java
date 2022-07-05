package les.scli.repositories;

// import java.util.Collection;

// import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import les.scli.model.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {

    // @Transactional
    // public Collection<Orcamento> findByCliente();

    // @Transactional
    // @Query(value = "SELECT COUNT(ORCAMENTO.DATA_INICIO) FROM ORCAMENTO WHERE ORCAMENTO.ID < 3", nativeQuery = true)
    // public Collection<Orcamento> findByCliente(Integer idCliente);
    
}
