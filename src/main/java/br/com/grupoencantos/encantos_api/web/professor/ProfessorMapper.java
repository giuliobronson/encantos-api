package br.com.grupoencantos.encantos_api.web.professor;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.domain.professor.Professor;
import br.com.grupoencantos.encantos_api.web.professor.dto.CreateProfessorDto;
import br.com.grupoencantos.encantos_api.web.professor.dto.DetailsProfessorDto;

@Component
public class ProfessorMapper {

    public DetailsProfessorDto toDto(Professor professor) {
        return new DetailsProfessorDto(
            professor.getId(),
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
