package br.com.grupoencantos.encantos_api.web.aluno.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlunoDto implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotNull
    @Past
    private LocalDate dataNascimento;

}
