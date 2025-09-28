package br.com.atos.gestao_alugueis.controllers;

import br.com.atos.gestao_alugueis.dtos.InquilinoDto;
import br.com.atos.gestao_alugueis.models.Inquilino;
import br.com.atos.gestao_alugueis.services.InquilinoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;
    private final ModelMapper modelMapper;

    public InquilinoController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping
    private ResponseEntity<InquilinoDto> save(@Valid @RequestBody InquilinoDto inquilinoDto){
        Inquilino inquilino = modelMapper.map(inquilinoDto, Inquilino.class);
        Inquilino inq = inquilinoService.save(inquilino);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(inq, InquilinoDto.class));
    }
    
}
