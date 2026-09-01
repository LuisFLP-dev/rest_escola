package com.github.luisflp_dev.rest_escola.academico.tipocurso;

import com.github.luisflp_dev.rest_escola.academico.curso.Curso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tipo_curso")
@Getter
@Setter
public class TipoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_curso")
    private Long idTipoCurso;

    @Column(name = "tx_descricao", length = 150, nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "tipoCurso", fetch = FetchType.LAZY)
    private Set<Curso> cursos;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoCurso)) return false;

        TipoCurso other = (TipoCurso) o;

        return idTipoCurso != null && idTipoCurso.equals(other.getIdTipoCurso());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
