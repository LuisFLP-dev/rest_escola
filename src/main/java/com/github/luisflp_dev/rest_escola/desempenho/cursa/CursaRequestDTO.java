package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CursaRequestDTO(
        @NotNull Long idAluno,
        @NotNull Long idDisciplina,
        @NotNull Integer ano,
        @NotNull Integer semestre,
        @NotNull @Min(0) Integer faltas,
        @Min(0) BigDecimal nota1,
        @Min(0) BigDecimal nota2,
        @Min(0) BigDecimal nota3,
        @NotNull Boolean aprovado
) {}