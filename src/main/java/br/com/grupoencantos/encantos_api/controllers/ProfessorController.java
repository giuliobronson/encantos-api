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

import br.com.grupoencantos.encantos_api.dto.CreateProfessorDto;
import br.com.grupoencantos.encantos_api.dto.DetailsProfessorDto;
import br.com.grupoencantos.encantos_api.dto.UpdateProfessorDto;
import br.com.grupoencantos.encantos_api.mappers.ProfessorMapper;
import br.com.grupoencantos.encantos_api.models.Professor;
import br.com.grupoencantos.encantos_api.repositories.ProfessorRepository;
import br.com.grupoencantos.encantos_api.services.ProfessorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    @Autowired
    private ProfessorService professorService;
    
    @PostMapping
    public ResponseEntity<DetailsProfessorDto> createProfessor(@RequestBody @Valid CreateProfessorDto dto, UriComponentsBuilder uriBuilder) {
        Professor professor = professorService.createProfessor(dto);
        URI uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(professorMapper.toDto(professor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsProfessorDto> getProfessor(@PathVariable Long id) {
        Professor professor = professorRepository.getReferenceById(id);
        return ResponseEntity.ok(professorMapper.toDto(professor));
    }

    @GetMapping
    public Page<DetailsProfessorDto> getProfessores(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        return professorRepository.findAllByAtivoTrue(pagination).map(professor -> professorMapper.toDto(professor));
    }

    @PutMapping
    public ResponseEntity<DetailsProfessorDto> updateProfessor(@RequestBody @Valid UpdateProfessorDto dto) {
        Professor professor = professorService.updateProfessor(dto);
        return ResponseEntity.ok(professorMapper.toDto(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }

}
