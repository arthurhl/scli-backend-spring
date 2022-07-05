package les.scli.repositories;

// import java.util.Collection;

// import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import les.scli.model.Cliente;

//Jonatan Bandeira
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // @Transactional
    // @Query(value = "SELECT * FROM ORCAMENTO AS ORC INNER JOIN SERVICO AS SER ON ORC.ID = SER.ORCAMENTO_ID INNER JOIN REALIZAR_SERVICO_EMPRESA AS REL_EMP ON SER.ID = REL_EMP.SERVICO_ID AND ORC.CLIENTE_ID = 1 UNION SELECT * FROM ORCAMENTO AS ORC INNER JOIN SERVICO AS SER ON ORC.ID = SER.ORCAMENTO_ID INNER JOIN REALIZAR_SERVICO_EMPRESA AS REL_EMP ON SER.ID = REL_EMP.SERVICO_ID AND ORC.CLIENTE_ID = 1", nativeQuery = true)
    // public Collection<Cliente> findDebito();

}
