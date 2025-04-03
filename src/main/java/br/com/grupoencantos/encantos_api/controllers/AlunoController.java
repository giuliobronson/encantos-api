package br.com.grupoencantos.encantos_api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.grupoencantos.encantos_api.dto.CreateAlunoDto;
import br.com.grupoencantos.encantos_api.dto.DetailsAlunoDto;
import br.com.grupoencantos.encantos_api.mappers.AlunoMapper;
import br.com.grupoencantos.encantos_api.models.Aluno;
import br.com.grupoencantos.encantos_api.repositories.AlunoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    @PostMapping
    public ResponseEntity<DetailsAlunoDto> createAluno(@RequestBody @Valid CreateAlunoDto dto, UriComponentsBuilder uriBuilder) {
        Aluno aluno = alunoMapper.toEntity(dto);
        alunoRepository.save(aluno);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(alunoMapper.toDto(aluno));
    }

}
