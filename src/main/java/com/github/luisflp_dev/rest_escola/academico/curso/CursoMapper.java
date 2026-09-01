package com.github.luisflp_dev.rest_escola.academico.curso;

import com.github.luisflp_dev.rest_escola.academico.instituicao.InstituicaoMapper;
import com.github.luisflp_dev.rest_escola.academico.tipocurso.TipoCursoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InstituicaoMapper.class, TipoCursoMapper.class})
public interface CursoMapper {

    @Mapping(target = "idCurso", ignore = true)
    @Mapping(target = "instituicao", ignore = true)
    @Mapping(target = "tipoCurso", ignore = true)
    @Mapping(target = "disciplinas", ignore = true)
    Curso toEntity(CursoRequestDTO cursoDTO);

    @Mapping(target = "instituicaoResponseDTO", source = "instituicao")
    @Mapping(target = "tipoCursoResponseDTO", source = "tipoCurso")
    CursoResponseDTO toDTO(Curso curso);
}
