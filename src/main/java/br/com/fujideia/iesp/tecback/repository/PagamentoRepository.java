package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    @Query("select id_cliente, valor, data_pagamento, data_vencimento from tb_pagamento order by id_cliente ASC")
    public List<Pagamento> listarOrdernadoPorNome();
    public List<Pagamento> findAllByOrderByNomeAsc();

    @Query("select id_cliente, valor, data_pagamento, data_vencimento from tb_pagamento a where id_cliente = id ")
    public List<Pagamento> buscarPagamentoPorNomeLike(@Param("id") Integer id);
}
