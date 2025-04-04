package br.com.grupoencantos.encantos_api.mappers;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.dto.CreateAlunoDto;
import br.com.grupoencantos.encantos_api.dto.DetailsAlunoDto;
import br.com.grupoencantos.encantos_api.models.Aluno;

@Component
public class AlunoMapper {

    public DetailsAlunoDto toDto(Aluno aluno) {
        DetailsAlunoDto dto = new DetailsAlunoDto();
        dto.setNome(aluno.getNome());
        dto.setCpf(aluno.getCpf());
        dto.setDataNascimento(aluno.getDataNascimento());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public Aluno toEntity(CreateAlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setDataNascimento(dto.getDataNascimento());
        return aluno;
    }

}
