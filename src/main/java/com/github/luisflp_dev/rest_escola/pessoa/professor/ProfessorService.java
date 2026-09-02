package com.github.luisflp_dev.rest_escola.pessoa.professor;

import com.github.luisflp_dev.rest_escola.academico.titulo.Titulo;
import com.github.luisflp_dev.rest_escola.academico.titulo.TituloRepository;
import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorMapper professorMapper;
    private final ProfessorRepository professorRepository;
    private final TituloRepository tituloRepository;

    @Transactional(readOnly = true)
    public Page<ProfessorResponseDTO> listAll(Pageable pageable){
        return professorRepository.findAll(pageable).map(professorMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public ProfessorResponseDTO getById(Integer idProfessor){
        Professor professor = professorRepository.findById(idProfessor).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do professor com o id: " + idProfessor)
        );

        return professorMapper.toDTO(professor);
    }

    @Transactional
    public ProfessorResponseDTO create(ProfessorRequestDTO professorDTO){
        Titulo titulo = tituloRepository.findById(professorDTO.idTitulo()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do titulo de id: " + professorDTO.idTitulo())
        );

        Professor professor = professorMapper.toEntity(professorDTO);
        professor.setTitulo(titulo);

        Professor saved = professorRepository.save(professor);
        return professorMapper.toDTO(saved);
    }

    @Transactional
    public ProfessorResponseDTO update(Integer idProfessor, ProfessorRequestDTO professorDTO){
        Professor professor = professorRepository.findById(idProfessor).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do professor com o id: " + idProfessor)
        );

        Titulo titulo = tituloRepository.findById(professorDTO.idTitulo()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do titulo de id: " + professorDTO.idTitulo())
        );

        professor.setTitulo(titulo);
        professor.setNome(professorDTO.nome());
        professor.setSexo(professorDTO.sexo());
        professor.setEstadoCivil(professorDTO.estadoCivil());
        professor.setDataNascimento(professorDTO.dataNascimento());
        professor.setTelefone(professorDTO.telefone());

        Professor updated = professorRepository.save(professor);
        return professorMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idProfessor){
        Professor professor = professorRepository.findById(idProfessor).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do professor com o id: " + idProfessor)
        );
        professorRepository.delete(professor);
    }
}
