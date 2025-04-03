package br.com.grupoencantos.encantos_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupoencantos.encantos_api.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
