package com.github.luisflp_dev.rest_escola.academico.tipodisciplina;

import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TipoDisciplinaService {

    private final TipoDisciplinaRepository tipoDisciplinaRepository;
    private final TipoDisciplinaMapper tipoDisciplinaMapper;

    @Transactional(readOnly = true)
    public Page<TipoDisciplinaResponseDTO> listAll(Pageable pageable){
        return tipoDisciplinaRepository.findAll(pageable).map(tipoDisciplinaMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public TipoDisciplinaResponseDTO getById(Integer idTipoDisciplina){
        TipoDisciplina tipoDisciplina = tipoDisciplinaRepository.findById(idTipoDisciplina).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de TipoDisciplina de id: " + idTipoDisciplina)
        );

        return tipoDisciplinaMapper.toDTO(tipoDisciplina);
    }

    @Transactional
    public TipoDisciplinaResponseDTO create(TipoDisciplinaRequestDTO tipoDisciplinaDTO){
        TipoDisciplina tipoDisciplina = tipoDisciplinaMapper.toEntity(tipoDisciplinaDTO);
        TipoDisciplina saved = tipoDisciplinaRepository.save(tipoDisciplina);

        return tipoDisciplinaMapper.toDTO(saved);
    }

    @Transactional
    public  TipoDisciplinaResponseDTO update(Integer idTipoDisciplina, TipoDisciplinaRequestDTO tipoDisciplinaDTO){
        TipoDisciplina tipoDisciplina = tipoDisciplinaRepository.findById(idTipoDisciplina).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de TipoDisciplina de id: " + idTipoDisciplina)
        );

        tipoDisciplina.setDescricao(tipoDisciplinaDTO.descricao());

        TipoDisciplina updated = tipoDisciplinaRepository.save(tipoDisciplina);
        return tipoDisciplinaMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idTipoDisciplina){
        TipoDisciplina tipoDisciplina = tipoDisciplinaRepository.findById(idTipoDisciplina).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de TipoDisciplina de id: " + idTipoDisciplina)
        );

        tipoDisciplinaRepository.delete(tipoDisciplina);
    }
}
