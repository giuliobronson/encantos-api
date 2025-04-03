package br.com.grupoencantos.encantos_api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.grupoencantos.encantos_api.enums.Status;
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
    private Status status;

}
