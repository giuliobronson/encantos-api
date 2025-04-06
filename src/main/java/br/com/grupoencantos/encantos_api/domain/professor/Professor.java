package br.com.grupoencantos.encantos_api.domain.professor;

import java.time.LocalDate;
import java.util.List;

import br.com.grupoencantos.encantos_api.domain.disciplina.Disciplina;
import br.com.grupoencantos.encantos_api.domain.turma.Turma;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Professor")
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
public class Professor {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Setter(AccessLevel.NONE)
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @OneToMany
    private List<Disciplina> disciplinas;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

    public Professor(String nome, String cpf, String email, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = LocalDate.now();
        this.ativo = true;
    }

}
