package br.com.grupoencantos.encantos_api.mappers;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.dto.CreateAlunoDto;
import br.com.grupoencantos.encantos_api.dto.DetailsAlunoDto;
import br.com.grupoencantos.encantos_api.models.Aluno;

@Component
public class AlunoMapper {

    public DetailsAlunoDto toDto(Aluno aluno) {
        return new DetailsAlunoDto(
            aluno.getNome(),
            aluno.getCpf(),
            aluno.getDataNascimento(),
            aluno.getDataCadastro()
        );
    }

    public Aluno toEntity(CreateAlunoDto dto) {
        return new Aluno(
            dto.getNome(),
            dto.getCpf(),
            dto.getDataNascimento()
        );
    }

}
