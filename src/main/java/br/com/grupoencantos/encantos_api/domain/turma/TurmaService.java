package br.com.grupoencantos.encantos_api.domain.turma;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupoencantos.encantos_api.domain.aluno.Aluno;
import br.com.grupoencantos.encantos_api.domain.aluno.AlunoRepository;
import br.com.grupoencantos.encantos_api.domain.disciplina.DisciplinaRepository;
import br.com.grupoencantos.encantos_api.domain.professor.ProfessorRepository;
import br.com.grupoencantos.encantos_api.domain.turma.validators.CadastroAlunoValidator;
import br.com.grupoencantos.encantos_api.web.turma.dto.SubscribeAlunoDto;
import br.com.grupoencantos.encantos_api.web.turma.dto.UpdateTurmaDto;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private List<CadastroAlunoValidator> validators;

    public Turma updateTurma(UpdateTurmaDto dto) {
        Turma turma = turmaRepository.getReferenceById(dto.getId());
        Optional.ofNullable(dto.getIdProfessor()).ifPresent(id -> {
            turma.setProfessor(professorRepository.getReferenceById(id));
        });
        Optional.ofNullable(dto.getIdDisciplina()).ifPresent(id -> {
            turma.setDisciplina(disciplinaRepository.getReferenceById(id));
        });
        turmaRepository.save(turma);
        return turma;
    }

    public void deleteTurma(Long id) {
        Turma turma = turmaRepository.getReferenceById(id);
        turma.setAtivo(false);
        turmaRepository.save(turma);
    }

    public Turma subscribeAluno(SubscribeAlunoDto dto) {
        Turma turma = turmaRepository.getReferenceById(dto.getIdTurma());
        Aluno aluno = alunoRepository.getReferenceById(dto.getIdAluno());

        validators.forEach(validator -> validator.validate(dto));

        turma.addAluno(aluno);
        turmaRepository.save(turma);
        return turma;
    }

}
