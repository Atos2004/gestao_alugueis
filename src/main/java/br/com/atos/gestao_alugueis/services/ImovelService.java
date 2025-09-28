package br.com.atos.gestao_alugueis.services;

import br.com.atos.gestao_alugueis.models.Imovel;
import br.com.atos.gestao_alugueis.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository){
        this.imovelRepository = imovelRepository;
    }

    public Imovel save(Imovel imovel) {
        Imovel imo = imovelRepository.save(imovel);
        return imo;
    }
}
