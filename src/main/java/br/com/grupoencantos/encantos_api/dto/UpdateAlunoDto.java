package br.com.grupoencantos.encantos_api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAlunoDto implements Serializable {

    @NotNull
    private Long Id;
    private String nome;

    @CPF
    private String cpf;
    private LocalDate dataNascimento;

}
