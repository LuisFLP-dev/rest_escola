package com.github.luisflp_dev.rest_escola.academico.curso;

import com.github.luisflp_dev.rest_escola.academico.disciplina.Disciplina;
import com.github.luisflp_dev.rest_escola.academico.instituicao.Instituicao;
import com.github.luisflp_dev.rest_escola.academico.tipocurso.TipoCurso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "curso", uniqueConstraints = { @UniqueConstraint(name = "uq_composta_curso", columnNames = {"id_instituicao", "id_tipo_curso", "tx_descricao"} )})
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_instituicao", nullable = false)
    private Instituicao instituicao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_curso", nullable = false)
    private TipoCurso tipoCurso;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private Set<Disciplina> disciplinas;

    @Column(name = "tx_descricao", length = 150, nullable = false)
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;

        Curso other = (Curso) o;

        return idCurso != null && idCurso.equals(other.getIdCurso());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
