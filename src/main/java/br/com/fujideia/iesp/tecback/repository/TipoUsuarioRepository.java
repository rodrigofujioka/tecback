package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Tipo_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<Tipo_Usuario, Integer> {

    @Query("select nome from tb_tipo_usuario order by nome ASC")
    public List<Tipo_Usuario> listarOrdernadoPorNome();
    public List<Tipo_Usuario> findAllByOrderByNomeAsc();

    @Query("select nome from tb_tipo_usuario a where nome like %:nome% ")
    public List<Tipo_Usuario> buscarTipoUsuarioPorNomeLike(@Param("nome") String nome);
}
