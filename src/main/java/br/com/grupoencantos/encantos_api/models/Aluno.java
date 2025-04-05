package br.com.grupoencantos.encantos_api.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Setter(AccessLevel.NONE)
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;
    
    @Column(name = "ATIVO")
    private Boolean ativo; 

    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turma;

    public Aluno(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = LocalDate.now();
        this.ativo = true;
    }

}
