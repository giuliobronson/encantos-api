package br.com.grupoencantos.encantos_api.domain.turma;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

    Page<Turma> findAllByAtivoTrue(Pageable pagination);

}
