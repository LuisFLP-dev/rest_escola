package com.github.luisflp_dev.rest_escola.pessoa.aluno;

import com.github.luisflp_dev.rest_escola.pessoa.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequestDTO(
        @NotBlank @Size(max = 100) String nome,
        @NotNull Sexo sexo,
        @NotNull @Past LocalDate dataNascimento
) {}