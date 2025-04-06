package br.com.grupoencantos.encantos_api.domain.disciplina;

import java.util.List;

import br.com.grupoencantos.encantos_api.domain.turma.Turma;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Disciplina")
@Table(name = "disciplinas")
@Getter
@Setter
@NoArgsConstructor
public class Disciplina {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", unique = true)
    private String nome;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "disciplina")
    private List<Turma> turmas;

    public Disciplina(String nome) {
        this.nome = nome;
        this.ativo = true;
    }

}
