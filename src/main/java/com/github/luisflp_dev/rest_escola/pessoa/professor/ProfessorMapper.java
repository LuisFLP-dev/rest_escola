package com.github.luisflp_dev.rest_escola.pessoa.professor;

import com.github.luisflp_dev.rest_escola.academico.titulo.TituloMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TituloMapper.class})
public interface ProfessorMapper {

    @Mapping(target = "titulo", ignore = true)
    @Mapping(target = "idProfessor", ignore = true)
    Professor toEntity(ProfessorRequestDTO professorDTO);

    @Mapping(target = "tituloResponseDTO", source = "titulo")
    ProfessorResponseDTO toDTO(Professor professor);

}
