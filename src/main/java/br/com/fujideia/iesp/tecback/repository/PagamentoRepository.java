package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
