package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Tipo_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<Tipo_Usuario, Integer> {
}
