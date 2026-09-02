package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CursaId implements Serializable {

    @Column(name = "id_aluno")
    private Integer idAluno;

    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    @Column(name = "in_ano")
    private Integer ano;

    @Column(name = "in_semestre")
    private Integer semestre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursaId)) return false;
        CursaId that = (CursaId) o;
        return Objects.equals(idAluno, that.idAluno)
                && Objects.equals(idDisciplina, that.idDisciplina)
                && Objects.equals(ano, that.ano)
                && Objects.equals(semestre, that.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAluno, idDisciplina, ano, semestre);
    }
}
