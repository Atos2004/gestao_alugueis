package br.com.atos.gestao_alugueis.services;

import br.com.atos.gestao_alugueis.dtos.AluguelDto;
import br.com.atos.gestao_alugueis.dtos.AluguelResponseDto;
import br.com.atos.gestao_alugueis.models.Aluguel;
import br.com.atos.gestao_alugueis.models.Imovel;
import br.com.atos.gestao_alugueis.models.Inquilino;
import br.com.atos.gestao_alugueis.repositories.AluguelRepository;
import br.com.atos.gestao_alugueis.repositories.ImovelRepository;
import br.com.atos.gestao_alugueis.repositories.InquilinoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private InquilinoRepository inquilinoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Aluguel save(Aluguel aluguel) {
        Aluguel alu = aluguelRepository.save(aluguel);
        return alu;
    }

    public AluguelResponseDto salvarAluguel(AluguelDto aluguelDto){
        Aluguel aluguel = new Aluguel();
        Imovel imovel = imovelRepository.findById(aluguelDto.getImovelId())
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado."));
        Inquilino inquilino = inquilinoRepository.findById(aluguelDto.getImovelId())
                .orElseThrow(() -> new RuntimeException("inquilino não encontrado."));

        aluguel.setImovel(imovel);
        aluguel.setInquilino(inquilino);
        aluguel.setValor(aluguelDto.getValor());
        aluguel.setDataVencimento(aluguelDto.getDataVencimento());

        Aluguel salvo = aluguelRepository.save(aluguel);
        return modelMapper.map(salvo, AluguelResponseDto.class);
    }


}
