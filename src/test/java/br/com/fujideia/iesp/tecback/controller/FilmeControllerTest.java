package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class FilmeControllerTest {

    @InjectMocks
    private FilmeController filmeController;

    @Mock
    private FilmeService filmeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ShouldListarTodosTest() {
        FilmeDTO filmeDTO1 = new FilmeDTO();
        FilmeDTO filmeDTO2 = new FilmeDTO();
        List<FilmeDTO> filmes = Arrays.asList(filmeDTO1, filmeDTO2);

        when(filmeService.listarTodos()).thenReturn(filmes);

        ResponseEntity<List<FilmeDTO>> response = filmeController.listarTodos();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(filmeService, times(1)).listarTodos();
    }

    @Test
    void ShouldBuscarPorIdTest_Found() {
        FilmeDTO filmeDTO = new FilmeDTO();
        when(filmeService.buscarPorId(1L)).thenReturn(Optional.of(filmeDTO));

        ResponseEntity<FilmeDTO> response = filmeController.buscarPorId(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filmeDTO, response.getBody());
        verify(filmeService, times(1)).buscarPorId(1L);
    }

    @Test
    void ShouldBuscarPorIdTest_NotFound() {
        when(filmeService.buscarPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<FilmeDTO> response = filmeController.buscarPorId(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(filmeService, times(1)).buscarPorId(1L);
    }

    @Test
    void ShouldCriarFilmeTest() {
        FilmeDTO filmeDTO = new FilmeDTO();
        when(filmeService.criarFilme(filmeDTO)).thenReturn(filmeDTO);

        ResponseEntity<FilmeDTO> response = filmeController.criarFilme(filmeDTO);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filmeDTO, response.getBody());
        verify(filmeService, times(1)).criarFilme(filmeDTO);
    }

    @Test
    void ShouldAtualizarFilmeTest_Found() {
        FilmeDTO filmeDetalhesDTO = new FilmeDTO();
        FilmeDTO filmeAtualizadoDTO = new FilmeDTO();
        when(filmeService.atualizarFilme(1L, filmeDetalhesDTO)).thenReturn(Optional.of(filmeAtualizadoDTO));

        ResponseEntity<FilmeDTO> response = filmeController.atualizarFilme(1L, filmeDetalhesDTO);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filmeAtualizadoDTO, response.getBody());
        verify(filmeService, times(1)).atualizarFilme(1L, filmeDetalhesDTO);
    }

    @Test
    void ShouldAtualizarFilmeTest_NotFound() {
        FilmeDTO filmeDetalhesDTO = new FilmeDTO();
        when(filmeService.atualizarFilme(1L, filmeDetalhesDTO)).thenReturn(Optional.empty());

        ResponseEntity<FilmeDTO> response = filmeController.atualizarFilme(1L, filmeDetalhesDTO);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(filmeService, times(1)).atualizarFilme(1L, filmeDetalhesDTO);
    }

    @Test
    void ShouldDeletarFilmeTest_Found() {
        when(filmeService.deletarFilme(1L)).thenReturn(true);

        ResponseEntity<Void> response = filmeController.deletarFilme(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(filmeService, times(1)).deletarFilme(1L);
    }

    @Test
    void ShouldDeletarFilmeTest_NotFound() {
        when(filmeService.deletarFilme(1L)).thenReturn(false);

        ResponseEntity<Void> response = filmeController.deletarFilme(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(filmeService, times(1)).deletarFilme(1L);
    }
}
