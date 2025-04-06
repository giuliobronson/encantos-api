package br.com.grupoencantos.encantos_api.web.professor.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProfessorDto implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Email
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone deve seguir o padrão (xx) xxxxx-xxxx")
    private String telefone;

    @NotNull
    @Past
    private LocalDate dataNascimento;

}
