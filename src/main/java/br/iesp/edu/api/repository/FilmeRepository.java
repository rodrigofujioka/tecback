package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmeRepository
        extends JpaRepository<Filme, Integer> {

}
