package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    @Query("select titulo from tb_filme order by titulo ASC")
    public List<Filme> listarOrdernadoPorNome();
    public List<Filme> findAllByOrderByNomeAsc();

    @Query("select titulo from tb_filme a where titulo like %:nome% ")
    public List<Filme> buscarFilmePorNomeLike(@Param("nome") String nome);


}
