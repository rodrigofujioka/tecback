package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Produtora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoraRepository extends JpaRepository<Produtora, Integer> {
    @Query("select titulo from tb_produtora order by titulo ASC")
    public List<Produtora> listarOrdernadoPorNome();
    public List<Produtora> findAllByOrderByNomeAsc();

    @Query("select titulo from tb_produtora a where titulo like %:nome% ")
    public List<Produtora> buscarProdutoraPorNomeLike(@Param("nome") String nome);
}
