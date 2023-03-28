package br.com.fujideia.iesp.tecback.repository;


import br.com.fujideia.iesp.tecback.model.Forma_Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<Forma_Pagamento, Integer> {
}
