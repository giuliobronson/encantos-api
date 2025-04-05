package br.com.grupoencantos.encantos_api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.grupoencantos.encantos_api.dto.CreateAlunoDto;
import br.com.grupoencantos.encantos_api.dto.DetailsAlunoDto;
import br.com.grupoencantos.encantos_api.dto.UpdateAlunoDto;
import br.com.grupoencantos.encantos_api.mappers.AlunoMapper;
import br.com.grupoencantos.encantos_api.models.Aluno;
import br.com.grupoencantos.encantos_api.repositories.AlunoRepository;
import br.com.grupoencantos.encantos_api.services.AlunoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsAlunoDto> createAluno(@RequestBody @Valid CreateAlunoDto dto, UriComponentsBuilder uriBuilder) {
        Aluno aluno = alunoService.createAluno(dto);
        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(alunoMapper.toDto(aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsAlunoDto> getAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        return ResponseEntity.ok(alunoMapper.toDto(aluno));
    }

    @GetMapping
    public Page<DetailsAlunoDto> getAlunos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        return alunoRepository.findAllByAtivoTrue(pagination).map(aluno -> alunoMapper.toDto(aluno));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsAlunoDto> updateAluno(@RequestBody @Valid UpdateAlunoDto dto) {
        Aluno aluno = alunoService.updateAluno(dto);
        return ResponseEntity.ok(alunoMapper.toDto(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }

}
