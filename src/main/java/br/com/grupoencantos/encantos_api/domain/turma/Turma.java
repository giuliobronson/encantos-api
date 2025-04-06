package br.com.grupoencantos.encantos_api.domain.turma;

import java.time.LocalDate;
import java.util.List;

import br.com.grupoencantos.encantos_api.domain.aluno.Aluno;
import br.com.grupoencantos.encantos_api.domain.disciplina.Disciplina;
import br.com.grupoencantos.encantos_api.domain.professor.Professor;
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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Turma")
@Table(name = "turma")
@Getter
@Setter
public class Turma {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROFESSOR")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "ID_DISCIPLINA")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(name = "TURMA_ALUNO",
        joinColumns = @JoinColumn(name = "ID_TURMA"),
        inverseJoinColumns = @JoinColumn(name = "ID_ALUNO"))
    private List<Aluno> alunos; 

    @Setter(AccessLevel.NONE)
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    @Column(name = "ATIVO")
    private Boolean ativo;

    public Turma(Professor professor, Disciplina disciplina, List<Aluno> alunos) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.dataCadastro = LocalDate.now();
        this.ativo = true;
    }

    public void addAluno(Aluno aluno) {
        this.getAlunos().add(aluno);
        aluno.getTurmas().add(this);
    }

}
