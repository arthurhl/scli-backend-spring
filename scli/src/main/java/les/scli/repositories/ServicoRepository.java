package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.Servico;

@Repository
public interface ServicoRepository  extends JpaRepository<Servico, Integer>{
    
}
