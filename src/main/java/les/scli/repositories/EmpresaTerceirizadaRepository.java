package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.EmpresaTerceirizada;

@Repository
public interface EmpresaTerceirizadaRepository extends JpaRepository<EmpresaTerceirizada, Integer>{
    
}
