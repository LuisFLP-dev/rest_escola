package com.github.luisflp_dev.rest_escola.academico.instituicao;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstituicaoMapper {
    @Mapping(target = "idInstituicao", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    Instituicao toEntity(InstituicaoRequestDTO instituicaoDTO);

    InstituicaoResponseDTO toDTO(Instituicao instituicao);
}