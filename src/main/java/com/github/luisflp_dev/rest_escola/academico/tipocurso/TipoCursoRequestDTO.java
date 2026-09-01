package com.github.luisflp_dev.rest_escola.academico.tipocurso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoCursoRequestDTO(
        @NotBlank @Size(max = 150) String descricao
) {}