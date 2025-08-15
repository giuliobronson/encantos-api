package br.com.grupoencantos.encantos_api.domain.aluno;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Page<Aluno> findAll(Specification<Aluno> spec, Pageable pagination);

    Optional<Aluno> findByCpf(String cpf);

}
