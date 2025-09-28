package br.com.atos.gestao_alugueis.controllers;

import br.com.atos.gestao_alugueis.dtos.ImovelDto;
import br.com.atos.gestao_alugueis.models.Imovel;
import br.com.atos.gestao_alugueis.services.ImovelService;
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
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;
    private final ModelMapper modelMapper;

    public ImovelController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping
    private ResponseEntity<ImovelDto> save(@Valid @RequestBody ImovelDto imovelDto){
        Imovel imovel = modelMapper.map(imovelDto, Imovel.class);
        Imovel imo = imovelService.save(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(imo, ImovelDto.class));
    }



}
