package br.com.grupoencantos.encantos_api.web.turma;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.domain.aluno.Aluno;
import br.com.grupoencantos.encantos_api.domain.aluno.AlunoRepository;
import br.com.grupoencantos.encantos_api.domain.disciplina.Disciplina;
import br.com.grupoencantos.encantos_api.domain.disciplina.DisciplinaRepository;
import br.com.grupoencantos.encantos_api.domain.professor.Professor;
import br.com.grupoencantos.encantos_api.domain.professor.ProfessorRepository;
import br.com.grupoencantos.encantos_api.domain.turma.Turma;
import br.com.grupoencantos.encantos_api.web.aluno.AlunoMapper;
import br.com.grupoencantos.encantos_api.web.aluno.dto.DetailsAlunoDto;
import br.com.grupoencantos.encantos_api.web.disciplina.DisciplinaMapper;
import br.com.grupoencantos.encantos_api.web.disciplina.dto.DetailsDisciplinaDto;
import br.com.grupoencantos.encantos_api.web.professor.ProfessorMapper;
import br.com.grupoencantos.encantos_api.web.professor.dto.DetailsProfessorDto;
import br.com.grupoencantos.encantos_api.web.turma.dto.CreateTurmaDto;
import br.com.grupoencantos.encantos_api.web.turma.dto.DetailsTurmaDto;

@Component
public class TurmaMapper {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Autowired
    private AlunoMapper alunoMapper;

    public Turma toEntity(CreateTurmaDto dto) {
        Professor professor = professorRepository.getReferenceById(dto.getIdProfessor());
        Disciplina disciplina = disciplinaRepository.getReferenceById(dto.getIdDisciplina());
        List<Aluno> alunos = Optional.ofNullable(dto.getIdAlunos())
            .orElse(Collections.emptyList())
            .stream()
            .map(idAluno -> alunoRepository.getReferenceById(idAluno))
            .collect(Collectors.toList());

        return new Turma(
            professor,
            disciplina,
            alunos
        );
    }

    public DetailsTurmaDto toDto(Turma turma) {
        DetailsProfessorDto professorDto = professorMapper.toDto(turma.getProfessor());
        DetailsDisciplinaDto disciplinaDto = disciplinaMapper.toDto(turma.getDisciplina());
        List<DetailsAlunoDto> alunoDtos = Optional.ofNullable(turma.getAlunos())
            .orElse(Collections.emptyList())
            .stream()
            .map(aluno -> alunoMapper.toDto(aluno))
            .collect(Collectors.toList());
        return new DetailsTurmaDto(
            turma.getId(),
            professorDto,
            disciplinaDto,
            alunoDtos
        );
    }

}
