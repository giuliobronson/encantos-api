package br.com.grupoencantos.encantos_api.web.turma.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeAlunoDto {

    @NotNull
    private Long idTurma;

    @NotNull
    private Long idAluno;
    
}
