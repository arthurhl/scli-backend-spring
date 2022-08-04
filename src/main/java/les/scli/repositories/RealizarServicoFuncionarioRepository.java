package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.RealizarServicoFuncionario;

@Repository
public interface RealizarServicoFuncionarioRepository extends JpaRepository<RealizarServicoFuncionario, Integer>{
	  @Transactional(readOnly = true)
	    @Query(value = "SELECT COUNT(STATUS) FROM REALIZAR_SERVICO_FUNCIONARIO WHERE STATUS IS FALSE AND FUNCIONARIO_ID = ?1", nativeQuery = true)
	    public Integer findCountServico(Integer id);

	    @Transactional(readOnly = true)
	    @Query(value = "SELECT COUNT(1) FROM REALIZAR_SERVICO_FUNCIONARIO where servico_id = ?1 AND status = FALSE", nativeQuery = true)
	    public Integer findCountFeedback(Integer id);
}
