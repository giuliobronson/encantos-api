package br.com.grupoencantos.encantos_api.web.disciplina;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.domain.disciplina.Disciplina;
import br.com.grupoencantos.encantos_api.web.disciplina.dto.CreateDisciplinaDto;
import br.com.grupoencantos.encantos_api.web.disciplina.dto.DetailsDisciplinaDto;

@Component
public class DisciplinaMapper {

    public DetailsDisciplinaDto toDto(Disciplina disciplina) {
        return new DetailsDisciplinaDto(disciplina.getId(), disciplina.getNome());
    }

    public Disciplina toEntity(CreateDisciplinaDto dto) {
        return new Disciplina(dto.getNome());
    }

}
