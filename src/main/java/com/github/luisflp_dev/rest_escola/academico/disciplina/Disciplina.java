package com.github.luisflp_dev.rest_escola.academico.disciplina;

import com.github.luisflp_dev.rest_escola.academico.curso.Curso;
import com.github.luisflp_dev.rest_escola.academico.tipodisciplina.TipoDisciplina;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_curso", nullable = true)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_disciplina", nullable = false)
    private TipoDisciplina tipoDisciplina;

    @Column(name = "tx_sigla", length = 10, nullable = false, unique = true)
    private String sigla;

    @Column(name = "tx_descricao", length = 150, nullable = false, unique = true)
    private String descricao;

    @Column(name = "in_periodo", nullable = false)
    private Integer periodo;

    @Column(name = "in_carga_horaria", nullable = false)
    private Integer cargaHoraria;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;

        Disciplina other = (Disciplina) o;

        return idDisciplina != null && idDisciplina.equals(other.getIdDisciplina());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }


}
