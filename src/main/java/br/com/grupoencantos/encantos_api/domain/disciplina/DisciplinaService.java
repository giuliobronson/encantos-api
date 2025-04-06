package br.com.grupoencantos.encantos_api.domain.disciplina;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupoencantos.encantos_api.web.disciplina.dto.UpdateDisciplinaDto;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina updateDisciplina(UpdateDisciplinaDto dto) {
        Disciplina disciplina = disciplinaRepository.getReferenceById(dto.getId());
        Optional.ofNullable(dto.getNome()).ifPresent(disciplina::setNome);
        return disciplinaRepository.save(disciplina);
    }

    public void deleteDisciplina(Long id) {
        Disciplina disciplina = disciplinaRepository.getReferenceById(id);
        disciplina.setAtivo(false);
        disciplinaRepository.save(disciplina);
    }

}
