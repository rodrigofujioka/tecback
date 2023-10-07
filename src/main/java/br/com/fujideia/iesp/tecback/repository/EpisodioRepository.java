package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Integer> {
}
