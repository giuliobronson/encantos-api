package br.com.grupoencantos.encantos_api.domain.professor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    Page<Professor> findAllByAtivoTrue(Pageable pagination);
    
    Optional<Professor> findByCpf(String cpf);
    
}
