package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.RealizarServicoEmpresa;

@Repository
public interface RealizarServicoEmpresaRepository extends JpaRepository<RealizarServicoEmpresa, Integer>{
    
}
