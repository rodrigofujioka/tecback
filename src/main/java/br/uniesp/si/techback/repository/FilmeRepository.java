package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
    // ========== Query Methods ==========
    
    // Busca por título (case-insensitive)
    List<Filme> findByTituloContainingIgnoreCase(String titulo);
    
    // Busca por gênero
    List<Filme> findByGenero(String genero);
    
    // Busca por classificação indicativa
    List<Filme> findByClassificacaoIndicativa(String classificacao);
    
    // Busca por ano de lançamento
    @Query("SELECT f FROM Filme f WHERE YEAR(f.dataLancamento) = :ano")
    List<Filme> buscarPorAnoLancamento(@Param("ano") int ano);
    
    // ========== JPQL Queries ==========
    
    // Busca filmes com duração maior ou igual ao valor informado
    @Query("SELECT f FROM Filme f WHERE f.duracaoMinutos >= :duracao")
    List<Filme> buscarPorDuracaoMinima(@Param("duracao") int duracaoMinima);
    
    // Busca filmes lançados entre duas datas
    @Query("SELECT f FROM Filme f WHERE f.dataLancamento BETWEEN :dataInicio AND :dataFim")
    List<Filme> buscarPorIntervaloDataLancamento(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );
    
    // ========== Native Queries ==========
    
    // Busca filmes por palavra-chave na sinopse (case-insensitive)
    @Query(value = "SELECT * FROM filmes WHERE LOWER(sinopse) LIKE LOWER(CONCAT('%', :palavraChave, '%'))", 
           nativeQuery = true)
    List<Filme> buscarPorPalavraChaveNaSinopse(@Param("palavraChave") String palavraChave);
    
    // Conta quantos filmes existem por gênero
    @Query(value = "SELECT genero, COUNT(*) as total FROM filmes GROUP BY genero", 
           nativeQuery = true)
    List<Object[]> contarFilmesPorGenero();
    
    // Busca filmes ordenados por data de lançamento (mais recentes primeiro)
    @Query("SELECT f FROM Filme f ORDER BY f.dataLancamento DESC")
    List<Filme> buscarTodosOrdenadosPorDataLancamento();
}
