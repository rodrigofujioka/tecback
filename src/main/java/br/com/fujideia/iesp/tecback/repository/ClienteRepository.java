package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Cliente;
import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select titulo from tb_cliente order by titulo ASC")
    public List<Cliente> listarOrdernadoPorNome();
    public List<Cliente> findAllByOrderByNomeAsc();

    @Query("select titulo from tb_cliente a where titulo like %:nome% ")
    public List<Cliente> buscarClientePorNomeLike(@Param("nome") String nome);
}
