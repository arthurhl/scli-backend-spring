package les.scli.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.Reposicao;
import les.scli.utils.WeeklyExpense;
import les.scli.utils.WeeklyPurchase;

@Repository
public interface ReposicaoRepository extends JpaRepository<Reposicao, Integer>{
    @Transactional(readOnly = true)
    @Query(value = "select date_trunc('week', re.created_at) as semana, sum(pr.valor * re.quantidade) as valor from reposicao as re" 
    + " inner join item_reposicao as ir on re.id = ir.reposicao_id"
	+ " inner join produto as pr on ir.produto_id = pr.id where re.gerente_id = ?1 group by semana,valor order by 1 desc limit 1", nativeQuery = true)
    public Collection<WeeklyExpense> weeklyExpenseByManager(Integer idGerente);
    
    @Transactional(readOnly = true)
    @Query(value = "select date_trunc('week', re.created_at) as semana, sum(re.quantidade) as quantidade from reposicao as re"
	+ "where re.fornecedor_id= ?1 group by semana,quantidade order by 1 desc limit 1", nativeQuery = true)
    public Collection<WeeklyPurchase> weeklyPurchaseBySupplier(Integer idFuncionario);
}
