package br.com.atos.gestao_alugueis.controllers;

import br.com.atos.gestao_alugueis.dtos.AluguelDto;
import br.com.atos.gestao_alugueis.dtos.AluguelResponseDto;
import br.com.atos.gestao_alugueis.dtos.AtualizarPagamentoDto;
import br.com.atos.gestao_alugueis.models.Aluguel;
import br.com.atos.gestao_alugueis.services.AluguelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/teste")
    public ResponseEntity<AluguelResponseDto> saveAluguel(@Valid @RequestBody AluguelDto aluguelDto){
        AluguelResponseDto aluguelResponseDto = aluguelService.salvarAluguel(aluguelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelResponseDto);
    }

    @PatchMapping("/{id}/pago")
    public ResponseEntity<AluguelResponseDto> atualizarStatusPagamento(
            @PathVariable Long id,
            @RequestBody AtualizarPagamentoDto atualizarPagamentoDto){
        AluguelResponseDto responseDto = aluguelService.atualizarStatusPagamento(id, atualizarPagamentoDto.isPago());
        return ResponseEntity.ok(responseDto);

    }
}
