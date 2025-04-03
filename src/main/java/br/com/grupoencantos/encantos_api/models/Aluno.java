package br.com.grupoencantos.encantos_api.models;

import java.time.LocalDate;

import br.com.grupoencantos.encantos_api.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@Setter
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Setter(AccessLevel.NONE)
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status; 

    public Aluno() {
        this.dataCadastro = LocalDate.now();
        this.status = Status.ATIVO;
    }

}
