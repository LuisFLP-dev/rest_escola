package com.github.luisflp_dev.rest_escola.academico.curso;

import com.github.luisflp_dev.rest_escola.academico.instituicao.Instituicao;
import com.github.luisflp_dev.rest_escola.academico.instituicao.InstituicaoRepository;
import com.github.luisflp_dev.rest_escola.academico.tipocurso.TipoCurso;
import com.github.luisflp_dev.rest_escola.academico.tipocurso.TipoCursoRepository;
import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final InstituicaoRepository instituicaoRepository;
    private final TipoCursoRepository tipoCursoRepository;

    @Transactional(readOnly = true)
    public Page<CursoResponseDTO> listAll(Pageable pageable){
        return cursoRepository.findAll(pageable).map(cursoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public CursoResponseDTO getById(Integer idCurso){
        Curso curso = cursoRepository.findById(idCurso).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de curso de id: " + idCurso)
        );

        return cursoMapper.toDTO(curso);
    }

    @Transactional
    public CursoResponseDTO create(CursoRequestDTO cursoDTO){
        Instituicao instituicao = instituicaoRepository.findById(cursoDTO.idInstituicao()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de instituicao de id: " + cursoDTO.idInstituicao())
        );

        TipoCurso tipoCurso = tipoCursoRepository.findById(cursoDTO.idTipoCurso()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoCurso de id: " + cursoDTO.idTipoCurso())
        );

        Curso curso = cursoMapper.toEntity(cursoDTO);
        curso.setInstituicao(instituicao);
        curso.setTipoCurso(tipoCurso);

        Curso saved = cursoRepository.save(curso);
        return cursoMapper.toDTO(saved);
    }

    @Transactional
    public CursoResponseDTO update(Integer idCurso, CursoRequestDTO cursoDTO){
        Curso curso = cursoRepository.findById(idCurso).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de curso de id: " + idCurso)
        );

        Instituicao instituicao = instituicaoRepository.findById(cursoDTO.idInstituicao()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de instituicao de id: " + cursoDTO.idInstituicao())
        );

        TipoCurso tipoCurso = tipoCursoRepository.findById(cursoDTO.idTipoCurso()).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoCurso de id: " + cursoDTO.idTipoCurso())
        );

        curso.setInstituicao(instituicao);
        curso.setTipoCurso(tipoCurso);
        curso.setDescricao(cursoDTO.descricao());

        Curso updated = cursoRepository.save(curso);
        return cursoMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idCurso){
        Curso curso = cursoRepository.findById(idCurso).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de curso de id: " + idCurso)
        );

        cursoRepository.delete(curso);
    }
}