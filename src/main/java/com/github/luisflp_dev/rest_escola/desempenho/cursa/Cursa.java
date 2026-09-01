package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import com.github.luisflp_dev.rest_escola.academico.disciplina.Disciplina;
import com.github.luisflp_dev.rest_escola.pessoa.aluno.Aluno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cursa")
@Getter
@Setter
public class Cursa {

    @EmbeddedId
    private CursaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idAluno")
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idDisciplina")
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @Column(name = "in_faltas", nullable = false)
    private Integer faltas = 0;

    @Column(name = "nm_nota1", precision = 4, scale = 2)
    private BigDecimal nota1;

    @Column(name = "nm_nota2", precision = 4, scale = 2)
    private BigDecimal nota2;

    @Column(name = "nm_nota3", precision = 4, scale = 2)
    private BigDecimal nota3;

    @Column(name = "bl_aprovado", nullable = false)
    private Boolean aprovado = false;
}
