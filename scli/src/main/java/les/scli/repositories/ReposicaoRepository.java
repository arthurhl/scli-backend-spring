package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.scli.model.Reposicao;

@Repository
public interface ReposicaoRepository extends JpaRepository<Reposicao, Integer>{
    
}
