package br.com.grupoencantos.encantos_api.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupoencantos.encantos_api.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    Page<Professor> findAllByAtivoTrue(Pageable pagination);
    
    Optional<Professor> findByCpf(String cpf);
    
}
