package com.github.luisflp_dev.rest_escola.pessoa.professor;

import com.github.luisflp_dev.rest_escola.academico.titulo.TituloResponseDTO;
import com.github.luisflp_dev.rest_escola.pessoa.Sexo;

import java.time.LocalDate;

public record ProfessorResponseDTO(
        Integer idProfessor,
        TituloResponseDTO tituloResponseDTO,
        String nome,
        Sexo sexo,
        EstadoCivil estadoCivil,
        LocalDate dataNascimento,
        String telefone
) {}
