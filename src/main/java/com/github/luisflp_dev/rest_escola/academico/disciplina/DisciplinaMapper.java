package com.github.luisflp_dev.rest_escola.academico.disciplina;

import com.github.luisflp_dev.rest_escola.academico.curso.CursoMapper;
import com.github.luisflp_dev.rest_escola.academico.tipodisciplina.TipoDisciplinaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CursoMapper.class, TipoDisciplinaMapper.class})
public interface DisciplinaMapper {

    @Mapping(target = "idDisciplina", ignore = true)
    @Mapping(target = "curso", ignore = true)
    @Mapping(target = "tipoDisciplina", ignore = true)
    Disciplina toEntity(DisciplinaRequestDTO disciplinaDTO);

    @Mapping(target = "cursoResponseDTO", source = "curso")
    @Mapping(target = "tipoDisciplinaResponseDTO", source = "tipoDisciplina")
    DisciplinaResponseDTO toDTO(Disciplina disciplina);
}