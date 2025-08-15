package br.com.grupoencantos.encantos_api.domain.turma.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.domain.aluno.Aluno;
import br.com.grupoencantos.encantos_api.domain.aluno.AlunoRepository;
import br.com.grupoencantos.encantos_api.domain.turma.Turma;
import br.com.grupoencantos.encantos_api.domain.turma.TurmaRepository;
import br.com.grupoencantos.encantos_api.web.turma.dto.SubscribeAlunoDto;

@Component
public class AlunoRepetidoValidator implements CadastroAlunoValidator {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;
    
    public void validate(SubscribeAlunoDto dto) {
        Turma turma = turmaRepository.getReferenceById(dto.getIdTurma());
        Aluno aluno = alunoRepository.getReferenceById(dto.getIdAluno());
        if (turma.getAlunos().contains(aluno)) {
            throw new IllegalArgumentException("Aluno já está inscrito na turma");
        }
    }

}
