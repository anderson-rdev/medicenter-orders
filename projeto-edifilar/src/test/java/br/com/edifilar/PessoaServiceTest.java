package br.com.edifilar;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.edifilar.model.Pessoa;
import br.com.edifilar.model.Endereco;
import br.com.edifilar.repository.PessoaRepository;
import br.com.edifilar.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarPessoa() {
        // Montando endereço completo <Enderecos>
        Endereco endereco = new Endereco("12345-678", "Rua A", "100", "Apto 10", "Centro", "CidadeX", "SP");

        Pessoa pessoa = new Pessoa(null, "João",
                List.of(endereco));

        // Pessoa "salva" no repositório, com id gerado
        Pessoa pessoaSalva = new Pessoa(1L, "João",
                List.of(endereco));

        // Mock do repositório
        when(pessoaRepository.save(pessoa)).thenReturn(pessoaSalva);

        // Chamar método que será testado
        Pessoa resultado = pessoaService.cadastrar(pessoa);

        // Verificações
        assertNotNull(resultado.getId());
        assertEquals("João", resultado.getNome());
        assertEquals(1, resultado.getEnderecos().size());
        verify(pessoaRepository, times(1)).save(pessoa);

    }
}
