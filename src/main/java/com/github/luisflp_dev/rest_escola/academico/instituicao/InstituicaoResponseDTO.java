package com.github.luisflp_dev.rest_escola.academico.instituicao;

public record InstituicaoResponseDTO(
        Long idInstituicao,
        String sigla,
        String descricao
) {}