package br.com.grupoencantos.encantos_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDisciplinaDto {

    @NotNull
    private Long id;

    @NotBlank
    private String nome;

}
