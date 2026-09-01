package com.github.luisflp_dev.rest_escola.academico.tipodisciplina;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoDisciplinaRequestDTO(
        @NotBlank @Size(max = 150) String descricao
) {}