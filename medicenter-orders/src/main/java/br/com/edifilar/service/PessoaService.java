package br.com.edifilar.service;

import org.springframework.stereotype.Service;
import br.com.edifilar.model.Pessoa;
import br.com.edifilar.repository.PessoaRepository;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa cadastrar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}