package com.github.luisflp_dev.rest_escola.academico.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CursoRequestDTO(
        @NotNull Long idInstituicao,
        @NotNull Long idTipoCurso,
        @NotBlank @Size(max = 150) String descricao
) {}