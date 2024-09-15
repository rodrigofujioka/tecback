package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long>{
}