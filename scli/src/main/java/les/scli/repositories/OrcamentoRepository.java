package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(DEBITO) FROM ORCAMENTO AS ORC INNER JOIN FUNCIONARIO AS FUNC ON ORC.FUNCIONARIO_ID"
    + " = FUNC.ID INNER JOIN REALIZAR_SERVICO_FUNCIONARIO AS REA_FUNC ON FUNC.ID"
    + " = REA_FUNC.FUNCIONARIO_ID AND ORC.CLIENTE_ID = 1 AND REA_FUNC.DEBITO IS TRUE"
    + " UNION SELECT COUNT(DEBITO) FROM ORCAMENTO AS ORC INNER JOIN SERVICO AS SER ON ORC.ID"
    + " = SER.ORCAMENTO_ID INNER JOIN REALIZAR_SERVICO_EMPRESA AS REL_EMP ON SER.ID"
    + " = REL_EMP.SERVICO_ID AND ORC.CLIENTE_ID = 1 AND REL_EMP.DEBITO IS TRUE", nativeQuery = true)
    public Integer findDebito(Integer debito);

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(ORCAMENTO.DATA_INICIO) FROM ORCAMENTO WHERE ORCAMENTO.ID < ?3", nativeQuery = true)
    public Integer findQtdOrcamento(Integer idCliente);  
}
