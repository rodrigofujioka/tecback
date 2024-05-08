package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findByTitulo(String titulo);
    List<Filme> findByTituloOrderByTituloAsc(String titulo);

}
