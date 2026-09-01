package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import com.github.luisflp_dev.rest_escola.academico.disciplina.DisciplinaResponseDTO;
import com.github.luisflp_dev.rest_escola.pessoa.aluno.AlunoResponseDTO;

import java.math.BigDecimal;

public record CursaResponseDTO(
        Integer ano,
        Integer semestre,
        AlunoResponseDTO aluno,
        DisciplinaResponseDTO disciplina,
        Integer faltas,
        BigDecimal nota1,
        BigDecimal nota2,
        BigDecimal nota3,
        Boolean aprovado
) {}