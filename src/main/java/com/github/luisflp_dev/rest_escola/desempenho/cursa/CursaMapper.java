package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import com.github.luisflp_dev.rest_escola.academico.disciplina.DisciplinaMapper;
import com.github.luisflp_dev.rest_escola.pessoa.aluno.AlunoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AlunoMapper.class, DisciplinaMapper.class})
public interface CursaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aluno", ignore = true)
    @Mapping(target = "disciplina", ignore = true)
    Cursa toEntity(CursaRequestDTO dto);

    @Mapping(target = "aluno", source = "aluno")
    @Mapping(target = "disciplina", source = "disciplina")
    @Mapping(target = "ano", source = "id.ano")
    @Mapping(target = "semestre", source = "id.semestre")
    CursaResponseDTO toDTO(Cursa cursa);
}