package com.github.luisflp_dev.rest_escola.pessoa.aluno;

import com.github.luisflp_dev.rest_escola.pessoa.Sexo;

import java.time.LocalDate;

public record AlunoResponseDTO(
        Long idAluno,
        String nome,
        Sexo sexo,
        LocalDate dataNascimento
) {}
