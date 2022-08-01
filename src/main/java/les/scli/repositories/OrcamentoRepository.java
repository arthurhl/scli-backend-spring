package les.scli.repositories;

import java.util.Collection;
import java.util.Date;

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
    + " = REA_FUNC.FUNCIONARIO_ID AND ORC.CLIENTE_ID = ?1 AND REA_FUNC.DEBITO IS TRUE",  nativeQuery = true)
    public Integer findDebitoFuncionario(Integer debito); 

    
    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(DEBITO) FROM ORCAMENTO AS ORC INNER JOIN SERVICO AS SER ON ORC.ID"
    + " = SER.ORCAMENTO_ID INNER JOIN REALIZAR_SERVICO_EMPRESA AS REL_EMP ON SER.ID"
    + " = REL_EMP.SERVICO_ID AND ORC.CLIENTE_ID = ?1 AND REL_EMP.DEBITO IS TRUE", nativeQuery = true)
    public Integer findDebitoEmpresa(Integer debito); 

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*) FROM ORCAMENTO WHERE orcamento.cliente_id = ?1 and orcamento.data_inicio = CURRENT_DATE", nativeQuery = true)
    public Integer findQtdOrcamento(Integer idCliente);

    @Transactional(readOnly = true)
    @Query(value = "SELECT CLIENTE.NOME AS NOME, SUM(VALOR) AS TOTAL, COUNT(VALOR) AS QUANTIDADE FROM ORCAMENTO INNER JOIN CLIENTE ON ORCAMENTO.CLIENTE_ID GROUP BY (nome)", nativeQuery = true)
    public Collection<?> findTotaisAndQuantidadesOrcamentosOfClientesByPeriodo(Date dataInicio, Date dataTermino);  
}
