package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<Forma_Pagamento, Integer> {

    @Query("select tipo from tb_forma_pagamento order by tipo ASC")
    public List<Forma_Pagamento> listarOrdernadoPorNome();
    public List<Forma_Pagamento> findAllByOrderByNomeAsc();

    @Query("select id from tb_forma_pagamento a where id = id ")
    public List<Forma_Pagamento> buscarFormaPagamentoPorIdLike(@Param("id") Integer id);
}
