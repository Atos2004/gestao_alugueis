package br.com.atos.gestao_alugueis.repositories;

import br.com.atos.gestao_alugueis.models.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    Optional<Imovel> findByEndereco(String endereco);

}
