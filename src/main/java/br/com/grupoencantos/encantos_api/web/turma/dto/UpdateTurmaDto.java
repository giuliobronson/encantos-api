package br.com.grupoencantos.encantos_api.web.turma.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTurmaDto {

    private Long id;
    private Long idProfessor;
    private Long idDisciplina;

}
