package br.com.grupoencantos.encantos_api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.grupoencantos.encantos_api.dto.CreateDisciplinaDto;
import br.com.grupoencantos.encantos_api.dto.DetailsDisciplinaDto;
import br.com.grupoencantos.encantos_api.dto.UpdateDisciplinaDto;
import br.com.grupoencantos.encantos_api.mappers.DisciplinaMapper;
import br.com.grupoencantos.encantos_api.models.Disciplina;
import br.com.grupoencantos.encantos_api.repositories.DisciplinaRepository;
import br.com.grupoencantos.encantos_api.services.DisciplinaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Autowired
    private DisciplinaService disciplinaService;
    
    @PostMapping
    @Transactional
    public ResponseEntity<DetailsDisciplinaDto> createDisciplina(@RequestBody @Valid CreateDisciplinaDto dto, UriComponentsBuilder uriBuilder) {
        Disciplina disciplina = disciplinaMapper.toEntity(dto);
        disciplinaRepository.save(disciplina);
        URI uri = uriBuilder.path("/disciplinas/{id}").buildAndExpand(disciplina.getId()).toUri();
        return ResponseEntity.created(uri).body(disciplinaMapper.toDto(disciplina));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsDisciplinaDto> getDisciplina(@PathVariable Long id) {
        Disciplina disciplina = disciplinaRepository.getReferenceById(id);
        return ResponseEntity.ok(disciplinaMapper.toDto(disciplina));
    }

    @GetMapping
    public Page<DetailsDisciplinaDto> getDisciplinas(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        return disciplinaRepository.findAllByAtivoTrue(pagination).map(disciplina -> disciplinaMapper.toDto(disciplina));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsDisciplinaDto> updateDisciplina(@RequestBody @Valid UpdateDisciplinaDto dto) {
        Disciplina disciplina = disciplinaService.updateDisciplina(dto);
        return ResponseEntity.ok(disciplinaMapper.toDto(disciplina));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteDisciplina(@PathVariable Long id) {
        disciplinaService.deleteDisciplina(id);
        return ResponseEntity.noContent().build();
    }

}
