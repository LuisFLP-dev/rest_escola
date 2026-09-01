package com.github.luisflp_dev.rest_escola.academico.instituicao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InstituicaoRequestDTO(
        @NotBlank @Size(max = 15) String sigla,
        @NotBlank @Size(max = 150) String descricao
) {}
