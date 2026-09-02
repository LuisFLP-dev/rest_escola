package com.github.luisflp_dev.rest_escola.academico.titulo;

import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TituloService {

    private final TituloRepository tituloRepository;
    private final TituloMapper tituloMapper;

    @Transactional(readOnly = true)
    public Page<TituloResponseDTO> listAll(Pageable pageable){
        return tituloRepository.findAll(pageable).map(tituloMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public TituloResponseDTO getById(Integer idTitulo){
        Titulo titulo = tituloRepository.findById(idTitulo).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do titulo de id: " + idTitulo)
        );

        return tituloMapper.toDTO(titulo);
    }

    @Transactional
    public TituloResponseDTO create(TituloRequestDTO tituloDTO){
        Titulo titulo = tituloMapper.toEntity(tituloDTO);
        Titulo saved = tituloRepository.save(titulo);

        return tituloMapper.toDTO(saved);
    }

    @Transactional
    public TituloResponseDTO update(Integer idTitulo, TituloRequestDTO tituloDTO){
        Titulo titulo = tituloRepository.findById(idTitulo).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do titulo de id: " + idTitulo)
        );

        titulo.setDescricao(tituloDTO.descricao());

        Titulo updated = tituloRepository.save(titulo);
        return tituloMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idTitulo){
        Titulo titulo = tituloRepository.findById(idTitulo).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do titulo de id: " + idTitulo)
        );

        tituloRepository.delete(titulo);
    }
}
