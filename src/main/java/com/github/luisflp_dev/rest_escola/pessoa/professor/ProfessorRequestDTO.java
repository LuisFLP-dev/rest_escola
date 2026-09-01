package com.github.luisflp_dev.rest_escola.pessoa.professor;

import com.github.luisflp_dev.rest_escola.pessoa.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ProfessorRequestDTO(
        @NotNull Long idTitulo,
        @NotBlank @Size(max = 50) String nome,
        @NotNull Sexo sexo,
        @NotNull EstadoCivil estadoCivil,
        @NotNull @Past LocalDate dataNascimento,
        @NotBlank @Size(max = 13) String telefone
        ) {
}
