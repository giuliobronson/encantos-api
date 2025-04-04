package br.com.grupoencantos.encantos_api.mappers;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.dto.CreateProfessorDto;
import br.com.grupoencantos.encantos_api.dto.DetailsProfessorDto;
import br.com.grupoencantos.encantos_api.models.Professor;

@Component
public class ProfessorMapper {

    public DetailsProfessorDto toDto(Professor professor) {
        return new DetailsProfessorDto(
            professor.getNome(),
            professor.getCpf(),
            professor.getEmail(),
            professor.getTelefone(),
            professor.getDataNascimento(),
            professor.getDataCadastro()
        );
    }

    public Professor toEntity(CreateProfessorDto dto) {
        return new Professor(
            dto.getNome(),
            dto.getCpf(),
            dto.getEmail(),
            dto.getTelefone(),
            dto.getDataNascimento()
        );
    }

}
