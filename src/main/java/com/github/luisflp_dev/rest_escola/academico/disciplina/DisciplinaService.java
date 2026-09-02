package com.github.luisflp_dev.rest_escola.academico.disciplina;

import com.github.luisflp_dev.rest_escola.academico.curso.Curso;
import com.github.luisflp_dev.rest_escola.academico.curso.CursoRepository;
import com.github.luisflp_dev.rest_escola.academico.tipodisciplina.TipoDisciplina;
import com.github.luisflp_dev.rest_escola.academico.tipodisciplina.TipoDisciplinaRepository;
import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final DisciplinaMapper disciplinaMapper;
    private final CursoRepository cursoRepository;
    private final TipoDisciplinaRepository tipoDisciplinaRepository;

    @Transactional(readOnly = true)
    public Page<DisciplinaResponseDTO> listAll(Pageable pageable){
        return disciplinaRepository.findAll(pageable).map(disciplinaMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public DisciplinaResponseDTO getById(Integer idDisciplina){
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de disciplina de id: " + idDisciplina)
        );

        return disciplinaMapper.toDTO(disciplina);
    }

    @Transactional
    public DisciplinaResponseDTO create(DisciplinaRequestDTO disciplinaDTO){
        TipoDisciplina tipoDisciplina = tipoDisciplinaRepository.findById(disciplinaDTO.idTipoDisciplina()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoDisciplina de id: " + disciplinaDTO.idTipoDisciplina())
        );

        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);
        disciplina.setTipoDisciplina(tipoDisciplina);

        if (disciplinaDTO.idCurso() != null){
            Curso curso = cursoRepository.findById(disciplinaDTO.idCurso()).orElseThrow(
                    () -> new ObjectNotFoundException("Nao ha registro de curso de id: " + disciplinaDTO.idCurso())
            );
            disciplina.setCurso(curso);
        }

        Disciplina saved = disciplinaRepository.save(disciplina);
        return disciplinaMapper.toDTO(saved);
    }

    @Transactional
    public DisciplinaResponseDTO update(Integer idDisciplina, DisciplinaRequestDTO disciplinaDTO){
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de disciplina de id: " + idDisciplina)
        );

        TipoDisciplina tipoDisciplina = tipoDisciplinaRepository.findById(disciplinaDTO.idTipoDisciplina()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoDisciplina de id: " + disciplinaDTO.idTipoDisciplina())
        );

        Curso curso = null;
        if (disciplinaDTO.idCurso() != null){
            curso = cursoRepository.findById(disciplinaDTO.idCurso()).orElseThrow(
                    () -> new ObjectNotFoundException("Nao ha registro de curso de id: " + disciplinaDTO.idCurso())
            );
        }

        disciplina.setCurso(curso);
        disciplina.setTipoDisciplina(tipoDisciplina);
        disciplina.setSigla(disciplinaDTO.sigla());
        disciplina.setDescricao(disciplinaDTO.descricao());
        disciplina.setPeriodo(disciplinaDTO.periodo());
        disciplina.setCargaHoraria(disciplinaDTO.cargaHoraria());

        Disciplina updated = disciplinaRepository.save(disciplina);
        return disciplinaMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idDisciplina){
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de disciplina de id: " + idDisciplina)
        );

        disciplinaRepository.delete(disciplina);
    }
}