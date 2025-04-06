package br.com.grupoencantos.encantos_api.web.turma;

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

import br.com.grupoencantos.encantos_api.domain.turma.Turma;
import br.com.grupoencantos.encantos_api.domain.turma.TurmaRepository;
import br.com.grupoencantos.encantos_api.domain.turma.TurmaService;
import br.com.grupoencantos.encantos_api.web.turma.dto.CreateTurmaDto;
import br.com.grupoencantos.encantos_api.web.turma.dto.DetailsTurmaDto;
import br.com.grupoencantos.encantos_api.web.turma.dto.SubscribeAlunoDto;
import br.com.grupoencantos.encantos_api.web.turma.dto.UpdateTurmaDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    
    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private TurmaMapper turmaMapper;

    @Autowired
    private TurmaService turmaService;
    
    @PostMapping
    @Transactional
    public ResponseEntity<DetailsTurmaDto> createTurma(@RequestBody @Valid CreateTurmaDto dto, UriComponentsBuilder uriBuilder) {
        Turma turma = turmaMapper.toEntity(dto);
        turmaRepository.save(turma);
        URI uri = uriBuilder.path("/turmas/{id}").buildAndExpand(turma.getId()).toUri();
        return ResponseEntity.created(uri).body(turmaMapper.toDto(turma));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsTurmaDto> getTurma(@PathVariable Long id) {
        Turma turma = turmaRepository.getReferenceById(id);
        return ResponseEntity.ok(turmaMapper.toDto(turma));
    }

    @GetMapping
    public Page<DetailsTurmaDto> getTurmas(@PageableDefault(size = 10) Pageable pagination) {
        return turmaRepository.findAllByAtivoTrue(pagination).map(turma -> turmaMapper.toDto(turma));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsTurmaDto> updateTurma(@RequestBody @Valid UpdateTurmaDto dto) {
        Turma turma = turmaService.updateTurma(dto);
        return ResponseEntity.ok(turmaMapper.toDto(turma));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsTurmaDto> subscribeAluno(@RequestBody @Valid SubscribeAlunoDto dto) {
        Turma turma = turmaService.subscribeAluno(dto);
        return ResponseEntity.ok(turmaMapper.toDto(turma));
    }

}
