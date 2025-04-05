package br.com.grupoencantos.encantos_api.mappers;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.dto.CreateDisciplinaDto;
import br.com.grupoencantos.encantos_api.dto.DetailsDisciplinaDto;
import br.com.grupoencantos.encantos_api.models.Disciplina;

@Component
public class DisciplinaMapper {

    public DetailsDisciplinaDto toDto(Disciplina disciplina) {
        return new DetailsDisciplinaDto(disciplina.getNome());
    }

    public Disciplina toEntity(CreateDisciplinaDto dto) {
        return new Disciplina(dto.getNome());
    }

}
