package com.github.luisflp_dev.rest_escola.academico.tipocurso;

import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TipoCursoService {

    private final TipoCursoRepository tipoCursoRepository;
    private final TipoCursoMapper tipoCursoMapper;

    @Transactional(readOnly = true)
    public Page<TipoCursoResponseDTO> listAll(Pageable pageable){
        return tipoCursoRepository.findAll(pageable).map(tipoCursoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public TipoCursoResponseDTO getById(Integer idTipoCurso){
        TipoCurso tipoCurso = tipoCursoRepository.findById(idTipoCurso).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoCurso de id: " + idTipoCurso)
        );

        return tipoCursoMapper.toDTO(tipoCurso);
    }

    @Transactional
    public TipoCursoResponseDTO create(TipoCursoRequestDTO tipoCursoDTO){
        TipoCurso tipoCurso = tipoCursoMapper.toEntity(tipoCursoDTO);
        TipoCurso saved = tipoCursoRepository.save(tipoCurso);

        return tipoCursoMapper.toDTO(saved);
    }

    @Transactional
    public TipoCursoResponseDTO update(Integer idTipoCurso, TipoCursoRequestDTO tipoCursoDTO){
        TipoCurso tipoCurso = tipoCursoRepository.findById(idTipoCurso).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoCurso de id: " + idTipoCurso)
        );

        tipoCurso.setDescricao(tipoCursoDTO.descricao());

        TipoCurso updated = tipoCursoRepository.save(tipoCurso);

        return tipoCursoMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idTipoCurso){
        TipoCurso tipoCurso = tipoCursoRepository.findById(idTipoCurso).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de tipoCurso de id: " + idTipoCurso)
        );

        tipoCursoRepository.delete(tipoCurso);
    }
}
