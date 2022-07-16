package les.scli.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.Reposicao;

@Repository
public interface ReposicaoRepository extends JpaRepository<Reposicao, Integer>{
    @Transactional(readOnly = true)
    @Query(value = "select sum(pr.valor * re.quantidade) as total from reposicao as re" 
    + " inner join item_reposicao as ir on re.id = ir.reposicao_id"
	+ " inner join produto as pr on ir.produto_id = pr.id" 
    + " where Date(re.created_at) between CURRENT_DATE - cast(EXTRACT (DOW from CURRENT_DATE) as int) + 1"
    + " and CURRENT_DATE + cast(abs(EXTRACT(DOW from CURRENT_DATE) - 7) + 1 as int)", nativeQuery = true)
    public Double weeklyExpenseByManager();
    
    @Transactional(readOnly = true)
    @Query(value = "select sum(re.quantidade) as quantidade from reposicao as re"
	+ " where re.fornecedor_id = ?1"
    + " and Date(re.created_at) between CURRENT_DATE - cast(EXTRACT (DOW from CURRENT_DATE) as int) + 1"
    + " and CURRENT_DATE + cast(abs(EXTRACT(DOW from CURRENT_DATE) - 7) + 1 as int)", nativeQuery = true)
    public Integer weeklyPurchaseBySupplier(Integer idFuncionario);
    
    @Transactional(readOnly = true)
    @Query(value = "select ge.nome as gerente, ir.quantidade, pr.nome as produto, pr.valor, fo.nome as fornecedor from reposicao as re"
    + " inner join gerente as ge on ge.id = re.gerente_id"
    + " inner join fornecedor as fo on fo.id = re.fornecedor_id"
    + " inner join item_reposicao as ir on ir.reposicao_id = re.id"
    + " inner join produto as pr on pr.id = ir.produto_id"
    + " where Date(re.created_at) >=  Date('2022-06-04') and  Date(re.updated_at) <= Date('2022-07-15')", nativeQuery = true)
    public Collection<?> listReplenishmentByPeriod(String beginning, String end);
}