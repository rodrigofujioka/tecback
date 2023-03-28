package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
