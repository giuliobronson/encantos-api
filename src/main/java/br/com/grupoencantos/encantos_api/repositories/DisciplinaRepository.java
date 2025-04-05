package br.com.grupoencantos.encantos_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupoencantos.encantos_api.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    Page<Disciplina> findAllByAtivoTrue(Pageable pagination);

}
