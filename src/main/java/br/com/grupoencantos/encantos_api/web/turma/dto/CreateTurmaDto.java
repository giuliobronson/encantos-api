package br.com.grupoencantos.encantos_api.web.turma.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTurmaDto implements Serializable {

    @NotNull
    private Long idProfessor;

    @NotNull
    private Long idDisciplina;

    @NotEmpty
    private List<@NotNull Long> idAlunos;

}
