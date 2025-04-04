package br.com.grupoencantos.encantos_api.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupoencantos.encantos_api.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Page<Aluno> findAllByAtivoTrue(Pageable pagination);

    Optional<Aluno> findByCpf(String cpf);

}
