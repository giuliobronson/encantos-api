package br.com.grupoencantos.encantos_api.web.turma.dto;

import java.io.Serializable;
import java.util.List;

import br.com.grupoencantos.encantos_api.web.aluno.dto.DetailsAlunoDto;
import br.com.grupoencantos.encantos_api.web.disciplina.dto.DetailsDisciplinaDto;
import br.com.grupoencantos.encantos_api.web.professor.dto.DetailsProfessorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailsTurmaDto implements Serializable {

    private Long id;
    private DetailsProfessorDto professorDto;
    private DetailsDisciplinaDto disciplinaDto;
    private List<DetailsAlunoDto> alunoDtos;

}
