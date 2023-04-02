package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select nome_usuario from tb_usuario order by nome_usuario ASC")
    public List<Usuario> listarOrdernadoPorNome();
    public List<Usuario> findAllByOrderByNomeAsc();

    @Query("select nome_usuario from tb_usuario a where nome_usuario like %:nome% ")
    public List<Usuario> buscarUsuarioPorNomeLike(@Param("nome") String nome);
}
