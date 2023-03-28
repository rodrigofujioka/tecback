package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Classificacao_Etaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificacaoEtariaRepository extends JpaRepository<Classificacao_Etaria, Integer> {
}
