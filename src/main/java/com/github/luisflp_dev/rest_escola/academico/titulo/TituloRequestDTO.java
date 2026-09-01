package com.github.luisflp_dev.rest_escola.academico.titulo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TituloRequestDTO(
        @NotBlank @Size(max = 150) String descricao
        ) {
}
