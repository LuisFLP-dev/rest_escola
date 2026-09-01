package com.github.luisflp_dev.rest_escola.academico.tipocurso;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoCursoMapper {
    @Mapping(target = "idTipoCurso", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    TipoCurso toEntity(TipoCursoRequestDTO tipoCursoDTO);

    TipoCursoResponseDTO toDTO(TipoCurso tipoCurso);
}