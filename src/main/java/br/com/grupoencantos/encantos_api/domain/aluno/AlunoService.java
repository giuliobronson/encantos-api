package br.com.grupoencantos.encantos_api.domain.aluno;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupoencantos.encantos_api.web.aluno.AlunoMapper;
import br.com.grupoencantos.encantos_api.web.aluno.dto.CreateAlunoDto;
import br.com.grupoencantos.encantos_api.web.aluno.dto.UpdateAlunoDto;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    public Aluno createAluno(CreateAlunoDto dto) {
        return alunoRepository.findByCpf(dto.getCpf())
            .map(aluno -> {
                aluno.setAtivo(true);
                aluno.setNome(dto.getNome());
                aluno.setDataNascimento(dto.getDataNascimento());
                return alunoRepository.save(aluno);
            })
            .orElseGet(() -> alunoRepository.save(alunoMapper.toEntity(dto)));
    }

    public Aluno updateAluno(UpdateAlunoDto dto) {
        Aluno aluno = alunoRepository.getReferenceById(dto.getId());
        Optional.ofNullable(dto.getNome()).ifPresent(aluno::setNome);
        Optional.ofNullable(dto.getCpf()).ifPresent(aluno::setCpf);
        Optional.ofNullable(dto.getDataNascimento()).ifPresent(aluno::setDataNascimento);
        alunoRepository.save(aluno);
        return aluno;
    }

    public void deleteAluno(Long id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.setAtivo(false);
        alunoRepository.save(aluno);
    }

}
