package br.com.atos.gestao_alugueis.repositories;

import br.com.atos.gestao_alugueis.models.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {

    Optional<Inquilino> findByEmail(String email);
}
