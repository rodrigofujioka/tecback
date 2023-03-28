package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer> {
}
