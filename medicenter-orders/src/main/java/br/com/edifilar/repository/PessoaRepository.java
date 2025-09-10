package br.com.edifilar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.edifilar.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}