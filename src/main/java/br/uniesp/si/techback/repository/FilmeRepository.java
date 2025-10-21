package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    //select * from Filme order by titulo asc
    @Query("select f * from Filme f order by f.titulo asc")
    public List<Filme> listarFilmesEmOrdemAlfabetica();


    @Query("select f * from Filme f" + "where f.dataLancamento =:ano.lancamento")
    public List<Filme> listarFilmesPorAno(@Param("anoLancamento")LocalDate anoLancamento);


}
