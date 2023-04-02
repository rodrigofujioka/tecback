package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    @Query("select titulo from tb_serie order by titulo ASC")
    public List<Serie> listarOrdernadoPorNome();
    public List<Serie> findAllByOrderByNomeAsc();

    @Query("select titulo from tb_serie a where titulo like %:nome% ")
    public List<Serie> buscarSeriePorNomeLike(@Param("nome") String nome);
}
