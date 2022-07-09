package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.RealizarServicoEmpresa;

@Repository
public interface RealizarServicoEmpresaRepository extends JpaRepository<RealizarServicoEmpresa, Integer>{
    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(STATUS) FROM REALIZAR_SERVICO_EMPRESA WHERE STATUS IS TRUE AND EMPRESA_TERCEIRIZADA_ID = ?1", nativeQuery = true)
    public Integer findCountServico(Integer id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(FEEDBACK) FROM REALIZAR_SERVICO_EMPRESA WHERE FEEDBACK IS FALSE AND EMPRESA_TERCEIRIZADA_ID = ?1", nativeQuery = true)
    public Integer findCountFeedback(Integer id);
}
