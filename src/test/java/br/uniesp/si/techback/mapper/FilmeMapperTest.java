package br.uniesp.si.techback.mapper;

import br.uniesp.si.techback.dto.FilmeDTO;
import br.uniesp.si.techback.model.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Testes do FilmeMapper")
class FilmeMapperTest {

    private FilmeMapper filmeMapper;
    private Filme filme;
    private FilmeDTO filmeDTO;

    @BeforeEach
    void setUp() {
        filmeMapper = new FilmeMapper(new ModelMapper());

        filme = Filme.builder()
                .id(1L)
                .titulo("Filme de Teste")
                .sinopse("Sinopse do filme de teste")
                .dataLancamento(LocalDate.of(2023, 1, 1))
                .genero("Ação")
                .duracaoMinutos(120)
                .classificacaoIndicativa("12 anos")
                .build();

        filmeDTO = FilmeDTO.builder()
                .id(1L)
                .titulo("Filme de Teste")
                .sinopse("Sinopse do filme de teste")
                .dataLancamento(LocalDate.of(2023, 1, 1))
                .genero("Ação")
                .duracaoMinutos(120)
                .classificacaoIndicativa("12 anos")
                .build();
    }

    @Test
    @DisplayName("Deve converter Entity para DTO")
    void deveConverterEntityParaDTO() {
        FilmeDTO resultado = filmeMapper.toDTO(filme);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(filme.getId());
        assertThat(resultado.getTitulo()).isEqualTo(filme.getTitulo());
        assertThat(resultado.getSinopse()).isEqualTo(filme.getSinopse());
        assertThat(resultado.getDataLancamento()).isEqualTo(filme.getDataLancamento());
        assertThat(resultado.getGenero()).isEqualTo(filme.getGenero());
        assertThat(resultado.getDuracaoMinutos()).isEqualTo(filme.getDuracaoMinutos());
        assertThat(resultado.getClassificacaoIndicativa()).isEqualTo(filme.getClassificacaoIndicativa());
    }

    @Test
    @DisplayName("Deve converter DTO para Entity")
    void deveConverterDTOParaEntity() {
        Filme resultado = filmeMapper.toEntity(filmeDTO);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(filmeDTO.getId());
        assertThat(resultado.getTitulo()).isEqualTo(filmeDTO.getTitulo());
        assertThat(resultado.getSinopse()).isEqualTo(filmeDTO.getSinopse());
        assertThat(resultado.getDataLancamento()).isEqualTo(filmeDTO.getDataLancamento());
        assertThat(resultado.getGenero()).isEqualTo(filmeDTO.getGenero());
        assertThat(resultado.getDuracaoMinutos()).isEqualTo(filmeDTO.getDuracaoMinutos());
        assertThat(resultado.getClassificacaoIndicativa()).isEqualTo(filmeDTO.getClassificacaoIndicativa());
    }

    @Test
    @DisplayName("Deve retornar null quando converter Entity null para DTO")
    void deveRetornarNullQuandoConverterEntityNullParaDTO() {
        FilmeDTO resultado = filmeMapper.toDTO(null);

        assertThat(resultado).isNull();
    }

    @Test
    @DisplayName("Deve retornar null quando converter DTO null para Entity")
    void deveRetornarNullQuandoConverterDTONullParaEntity() {
        Filme resultado = filmeMapper.toEntity(null);

        assertThat(resultado).isNull();
    }

    @Test
    @DisplayName("Deve converter Entity com campos nulos para DTO")
    void deveConverterEntityComCamposNulosParaDTO() {
        Filme filmeComNulos = Filme.builder()
                .id(2L)
                .titulo("Filme com Nulos")
                .sinopse(null)
                .dataLancamento(null)
                .genero(null)
                .duracaoMinutos(null)
                .classificacaoIndicativa(null)
                .build();

        FilmeDTO resultado = filmeMapper.toDTO(filmeComNulos);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(2L);
        assertThat(resultado.getTitulo()).isEqualTo("Filme com Nulos");
        assertThat(resultado.getSinopse()).isNull();
        assertThat(resultado.getDataLancamento()).isNull();
        assertThat(resultado.getGenero()).isNull();
        assertThat(resultado.getDuracaoMinutos()).isNull();
        assertThat(resultado.getClassificacaoIndicativa()).isNull();
    }

    @Test
    @DisplayName("Deve converter DTO com campos nulos para Entity")
    void deveConverterDTOComCamposNulosParaEntity() {
        FilmeDTO dtoComNulos = FilmeDTO.builder()
                .id(2L)
                .titulo("DTO com Nulos")
                .sinopse(null)
                .dataLancamento(null)
                .genero(null)
                .duracaoMinutos(null)
                .classificacaoIndicativa(null)
                .build();

        Filme resultado = filmeMapper.toEntity(dtoComNulos);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(2L);
        assertThat(resultado.getTitulo()).isEqualTo("DTO com Nulos");
        assertThat(resultado.getSinopse()).isNull();
        assertThat(resultado.getDataLancamento()).isNull();
        assertThat(resultado.getGenero()).isNull();
        assertThat(resultado.getDuracaoMinutos()).isNull();
        assertThat(resultado.getClassificacaoIndicativa()).isNull();
    }

    @Test
    @DisplayName("Deve manter consistência na conversão bidirecional")
    void deveManterConsistenciaNaConversaoBidirecional() {
        FilmeDTO dtoConvertido = filmeMapper.toDTO(filme);
        Filme entityReconvertida = filmeMapper.toEntity(dtoConvertido);

        assertThat(entityReconvertida.getId()).isEqualTo(filme.getId());
        assertThat(entityReconvertida.getTitulo()).isEqualTo(filme.getTitulo());
        assertThat(entityReconvertida.getSinopse()).isEqualTo(filme.getSinopse());
        assertThat(entityReconvertida.getDataLancamento()).isEqualTo(filme.getDataLancamento());
        assertThat(entityReconvertida.getGenero()).isEqualTo(filme.getGenero());
        assertThat(entityReconvertida.getDuracaoMinutos()).isEqualTo(filme.getDuracaoMinutos());
        assertThat(entityReconvertida.getClassificacaoIndicativa()).isEqualTo(filme.getClassificacaoIndicativa());
    }
}
