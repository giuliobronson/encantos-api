package br.com.grupoencantos.encantos_api.web.disciplina.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailsDisciplinaDto implements Serializable{

    private Long id;
    private String nome;

}
