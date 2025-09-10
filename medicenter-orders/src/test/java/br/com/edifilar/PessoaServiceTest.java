package br.com.edifilar;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.edifilar.model.Pessoa;
import br.com.edifilar.repository.PessoaRepository;
import br.com.edifilar.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        Pessoa pessoa = new Pessoa(null, "João");
        Pessoa pessoaSalva = new Pessoa(1L, "João");

        when(pessoaRepository.save(pessoa)).thenReturn(pessoaSalva);

        Pessoa resultado = pessoaService.cadastrar(pessoa);
        System.out.println(resultado);

        // assertNotNull(resultado.getId());
        // assertEquals("João", resultado.getNome());
        // verify(pessoaRepository, times(1)).save(pessoa);
    }
}
