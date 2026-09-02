package com.github.luisflp_dev.rest_escola.academico.curso;

import com.github.luisflp_dev.rest_escola.academico.instituicao.InstituicaoResponseDTO;
import com.github.luisflp_dev.rest_escola.academico.tipocurso.TipoCursoResponseDTO;

public record CursoResponseDTO(
        Integer idCurso,
        InstituicaoResponseDTO instituicaoResponseDTO,
        TipoCursoResponseDTO tipoCursoResponseDTO,
        String descricao
) {}
