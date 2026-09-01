package com.github.luisflp_dev.rest_escola.academico.tipodisciplina;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoDisciplinaMapper {
    @Mapping(target = "idTipoDisciplina", ignore = true)
    @Mapping(target = "disciplinas", ignore = true)
    TipoDisciplina toEntity(TipoDisciplinaRequestDTO tipoDisciplinaDTO);

    TipoDisciplinaResponseDTO toDTO(TipoDisciplina tipoDisciplina);
}