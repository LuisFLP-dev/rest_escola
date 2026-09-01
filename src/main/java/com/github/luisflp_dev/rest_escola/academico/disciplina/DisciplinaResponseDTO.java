package com.github.luisflp_dev.rest_escola.academico.disciplina;

import com.github.luisflp_dev.rest_escola.academico.curso.CursoResponseDTO;
import com.github.luisflp_dev.rest_escola.academico.tipodisciplina.TipoDisciplinaResponseDTO;

public record DisciplinaResponseDTO(
        Long idDisciplina,
        CursoResponseDTO cursoResponseDTO,
        TipoDisciplinaResponseDTO tipoDisciplinaResponseDTO,
        String sigla,
        String descricao,
        Integer periodo,
        Integer cargaHoraria
) {}