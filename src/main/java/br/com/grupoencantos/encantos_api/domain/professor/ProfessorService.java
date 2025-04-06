package br.com.grupoencantos.encantos_api.domain.professor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupoencantos.encantos_api.web.professor.ProfessorMapper;
import br.com.grupoencantos.encantos_api.web.professor.dto.CreateProfessorDto;
import br.com.grupoencantos.encantos_api.web.professor.dto.UpdateProfessorDto;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    public Professor createProfessor(CreateProfessorDto dto) {
        return professorRepository.findByCpf(dto.getCpf())
            .map(professor -> {
                professor.setAtivo(true);
                professor.setNome(dto.getNome());
                professor.setEmail(dto.getEmail());
                professor.setTelefone(dto.getTelefone());
                professor.setDataNascimento(dto.getDataNascimento());
                return professorRepository.save(professor);
            })
            .orElseGet(() -> professorRepository.save(professorMapper.toEntity(dto)));
    }

    public Professor updateProfessor(UpdateProfessorDto dto) {
        Professor professor = professorRepository.getReferenceById(dto.getId());
        Optional.ofNullable(dto.getNome()).ifPresent(professor::setNome);
        Optional.ofNullable(dto.getCpf()).ifPresent(professor::setCpf);
        Optional.ofNullable(dto.getEmail()).ifPresent(professor::setEmail);
        Optional.ofNullable(dto.getTelefone()).ifPresent(professor::setTelefone);
        Optional.ofNullable(dto.getDataNascimento()).ifPresent(professor::setDataNascimento);
        professorRepository.save(professor);
        return professor;
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.getReferenceById(id);
        professor.setAtivo(false);
        professorRepository.save(professor);
    }

}
