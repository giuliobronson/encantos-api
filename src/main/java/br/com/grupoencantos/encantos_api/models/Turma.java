package br.com.grupoencantos.encantos_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity(name = "Turma")
@Table(name = "turma")
@Getter
public class Turma {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROFESSOR")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "TURMA_ALUNO",
        joinColumns = @JoinColumn(name = "ID_TURMA"),
        inverseJoinColumns = @JoinColumn(name = "ID_ALUNO"))
    private List<Aluno> alunos; 

    @ManyToOne
    @JoinColumn(name = "ID_DISCIPLINA")
    private Disciplina disciplina;

}
