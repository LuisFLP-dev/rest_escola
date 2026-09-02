package com.github.luisflp_dev.rest_escola.academico.disciplina;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DisciplinaRequestDTO(
        Integer idCurso,
        @NotNull Integer idTipoDisciplina,
        @NotBlank @Size(max = 10) String sigla,
        @NotBlank @Size(max = 150) String descricao,
        @NotNull @Min(1) Integer periodo,
        @NotNull @Min(40) Integer cargaHoraria
) {}