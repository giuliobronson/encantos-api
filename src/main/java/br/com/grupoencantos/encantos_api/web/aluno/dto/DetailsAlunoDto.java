package br.com.grupoencantos.encantos_api.web.aluno.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailsAlunoDto implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

}
