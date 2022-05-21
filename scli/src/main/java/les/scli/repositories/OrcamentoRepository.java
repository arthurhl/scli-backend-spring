package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer>{
    
}
