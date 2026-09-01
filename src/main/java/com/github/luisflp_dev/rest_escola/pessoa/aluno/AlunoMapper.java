package com.github.luisflp_dev.rest_escola.pessoa.aluno;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "idAluno", ignore = true)
    Aluno toEntity(AlunoRequestDTO alunoDTO);

    AlunoResponseDTO toDTO(Aluno aluno);
}
