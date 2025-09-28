package br.com.atos.gestao_alugueis.repositories;

import br.com.atos.gestao_alugueis.models.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {



}
