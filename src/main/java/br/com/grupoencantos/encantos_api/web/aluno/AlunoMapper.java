package br.com.grupoencantos.encantos_api.web.aluno;

import org.springframework.stereotype.Component;

import br.com.grupoencantos.encantos_api.domain.aluno.Aluno;
import br.com.grupoencantos.encantos_api.web.aluno.dto.CreateAlunoDto;
import br.com.grupoencantos.encantos_api.web.aluno.dto.DetailsAlunoDto;

@Component
public class AlunoMapper {

    public DetailsAlunoDto toDto(Aluno aluno) {
        return new DetailsAlunoDto(
            aluno.getId(),
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
