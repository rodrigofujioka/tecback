package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    @Query("select titulo from tb_genero order by titulo ASC")
    public List<Genero> listarOrdernadoPorNome();
    public List<Genero> findAllByOrderByNomeAsc();

    @Query("select titulo from tb_genero a where titulo like %:nome% ")
    public List<Genero> buscarGeneroPorNomeLike(@Param("nome") String nome);
}
