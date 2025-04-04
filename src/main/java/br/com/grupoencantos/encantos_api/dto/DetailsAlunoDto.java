package br.com.grupoencantos.encantos_api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailsAlunoDto implements Serializable {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

}
