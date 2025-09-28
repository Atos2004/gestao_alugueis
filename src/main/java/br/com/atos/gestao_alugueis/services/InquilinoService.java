package br.com.atos.gestao_alugueis.services;

import br.com.atos.gestao_alugueis.controllers.InquilinoController;
import br.com.atos.gestao_alugueis.models.Imovel;
import br.com.atos.gestao_alugueis.models.Inquilino;
import br.com.atos.gestao_alugueis.repositories.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    public InquilinoService(InquilinoRepository inquilinoRepository){
        this.inquilinoRepository = inquilinoRepository;
    }

    public Inquilino save(Inquilino inquilino) {
        Inquilino inq = inquilinoRepository.save(inquilino);
        return inq;
    }

    private void findByEmail(Inquilino inquilino){
        Optional<Inquilino>  inq = inquilinoRepository.findByEmail(inquilino.getEmail());
        if ( inq.isPresent() &&  inq.get().getEmail().equals(inquilino.getEmail())){
            throw new IllegalArgumentException("Email já existe!");

        }
    }

}
