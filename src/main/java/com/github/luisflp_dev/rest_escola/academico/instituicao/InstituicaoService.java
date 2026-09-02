package com.github.luisflp_dev.rest_escola.academico.instituicao;

import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;
    private final InstituicaoMapper instituicaoMapper;

    @Transactional(readOnly = true)
    public Page<InstituicaoResponseDTO> listAll(Pageable pageable){
        return instituicaoRepository.findAll(pageable).map(instituicaoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public InstituicaoResponseDTO getById(Integer idInstituicao){
        Instituicao instituicao = instituicaoRepository.findById(idInstituicao).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de instituicao de id: " + idInstituicao)
        );

        return instituicaoMapper.toDTO(instituicao);
    }

    @Transactional
    public InstituicaoResponseDTO create(InstituicaoRequestDTO instituicaoDTO){
        Instituicao instituicao = instituicaoMapper.toEntity(instituicaoDTO);
        Instituicao saved = instituicaoRepository.save(instituicao);

        return instituicaoMapper.toDTO(saved);
    }

    @Transactional
    public InstituicaoResponseDTO update(Integer idInstituicao, InstituicaoRequestDTO instituicaoDTO){
        Instituicao instituicao = instituicaoRepository.findById(idInstituicao).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de instituicao de id: " + idInstituicao)
        );

        instituicao.setSigla(instituicaoDTO.sigla());
        instituicao.setDescricao(instituicaoDTO.descricao());

        Instituicao updated = instituicaoRepository.save(instituicao);

        return instituicaoMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idInstituicao){
        Instituicao instituicao = instituicaoRepository.findById(idInstituicao).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro de instituicao de id: " + idInstituicao)
        );

        instituicaoRepository.delete(instituicao);
    }
}