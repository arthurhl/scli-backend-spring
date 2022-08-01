package les.scli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import les.scli.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
  @Transactional(readOnly = true)
  @Query(value = "select count(*) from pedido as pe "
      + "where pe.cliente_id = ?1 "
      + "and Date(pe.created_at) between CURRENT_DATE - cast(EXTRACT(dow from CURRENT_DATE) as int) + 1 "
      + "and CURRENT_DATE + cast(abs(EXTRACT(dow from CURRENT_DATE) - 7) + 1 as int)", nativeQuery = true)
  public Integer getQuantidadeSemanal(Integer clientId);

  @Transactional(readOnly = true)
  @Query(value = "select sum(pe.valor) from pedido as pe "
      + "where pe.cliente_id = ?1 "
      + "and Date(pe.created_at) between CURRENT_DATE - cast(EXTRACT(dow from CURRENT_DATE) as int) + 1 "
      + "and CURRENT_DATE + cast(abs(EXTRACT(dow from CURRENT_DATE) - 7) + 1 as int)", nativeQuery = true)
  public Double maxValue(Integer clientId);
}
