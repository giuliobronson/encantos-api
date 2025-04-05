package br.com.grupoencantos.encantos_api.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDisciplinaDto implements Serializable{

    @NotBlank
    private String nome;

}
