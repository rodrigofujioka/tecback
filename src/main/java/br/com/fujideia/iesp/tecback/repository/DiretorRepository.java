package br.com.fujideia.iesp.tecback.repository;



import br.com.fujideia.iesp.tecback.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Integer> {

    @Query("select nome from tb_diretor order by nome ASC")
    public List<Diretor> listarOrdernadoPorNome();
    public List<Diretor> findAllByOrderByNomeAsc();

    @Query("select nome from tb_diretor a where nome like %:nome% ")
    public List<Diretor> buscarDiretorPorNomeLike(@Param("nome") String nome);
}
