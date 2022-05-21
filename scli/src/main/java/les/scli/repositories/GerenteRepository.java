package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer>{
    
}
