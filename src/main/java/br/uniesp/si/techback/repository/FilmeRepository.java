package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    public Filme findByTitulo(String titulo);
    public Filme findByAutor(String autor);
    public Filme findByTituloAndAutor(String titulo, String autor);
    public List<Filme> findFilmeByTituloIsLikeIgnoreCase(String titulo);
    public List<Filme> findFilmeByAutorIsLikeIgnoreCase(String autor);
    public List<Filme> findFilmeByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT f FROM Filme f WHERE f.titulo = :titulo")
    Filme buscarPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT f FROM Filme f WHERE f.autor = :autor")
    Filme buscarPorAutor(@Param("autor") String autor);

    @Query("SELECT f FROM Filme f WHERE f.titulo = :titulo AND f.autor = :autor")
    Filme buscarPorTituloEAutor(@Param("titulo") String titulo, @Param("autor") String autor);

    @Query("SELECT f FROM Filme f WHERE LOWER(f.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Filme> buscarPorTituloLikeIgnoreCase(@Param("titulo") String titulo);

    @Query("SELECT f FROM Filme f WHERE LOWER(f.autor) LIKE LOWER(CONCAT('%', :autor, '%'))")
    List<Filme> buscarPorAutorLikeIgnoreCase(@Param("autor") String autor);

    @Query("SELECT f FROM Filme f WHERE LOWER(f.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Filme> buscarFilmesComTituloContendo(@Param("titulo") String titulo);

    /**
     * Todos os métodos acima usam @Query com JPQL.
     *
     * LOWER + LIKE simula a busca case-insensitive.
     *
     * CONCAT('%', :param, '%') simula o LIKE %valor% usado nas queries derivadas.
     *
     * Os nomes dos métodos podem ser livres, já que com @Query o que vale é a string da query.
     */


}
