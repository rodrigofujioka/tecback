package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
