package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
}
