package br.com.grupoencantos.encantos_api.web.disciplina.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDisciplinaDto implements Serializable {

    @NotNull
    private Long id;

    @NotBlank
    private String nome;

}
