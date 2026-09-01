package com.github.luisflp_dev.rest_escola.academico.titulo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TituloMapper {

    @Mapping(target = "idTitulo", ignore = true)
    Titulo toEntity(TituloRequestDTO tituloDTO);

    TituloResponseDTO toDTO(Titulo titulo);
}
