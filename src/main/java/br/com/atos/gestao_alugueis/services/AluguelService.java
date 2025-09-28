package br.com.atos.gestao_alugueis.services;

import br.com.atos.gestao_alugueis.dtos.AluguelAtrasadoResponseDto;
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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

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


    public AluguelResponseDto atualizarStatusPagamento(Long id, boolean pago) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado."));

        aluguel.setPago(pago);
        Aluguel atualizado = aluguelRepository.save(aluguel);
        return modelMapper.map(atualizado, AluguelResponseDto.class);
    }

    public List<AluguelAtrasadoResponseDto> listarAtrasados(){
        LocalDate hoje = LocalDate.now();

        List<Aluguel> atrasados = aluguelRepository.findByPagoFalseAndDataVencimentoBefore(hoje);
        return atrasados.stream().map(aluguel -> {
            AluguelAtrasadoResponseDto dto = new AluguelAtrasadoResponseDto();
            dto.setId(aluguel.getAluguelId());
            dto.setImovel(aluguel.getImovel().getDescricao());
            dto.setInquilino(aluguel.getInquilino().getNome());
            dto.setValor(aluguel.getValor());

            long diasAtrasado = ChronoUnit.DAYS.between(aluguel.getDataVencimento(), hoje);
            dto.setDiasEmAtraso(diasAtrasado);

            return dto;
        }).collect(Collectors.toList());
    }

}
