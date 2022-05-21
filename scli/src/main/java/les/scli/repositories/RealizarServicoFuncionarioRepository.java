package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.RealizarServicoFuncionario;

@Repository
public interface RealizarServicoFuncionarioRepository extends JpaRepository<RealizarServicoFuncionario, Integer>{
    
}
