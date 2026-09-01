package com.github.luisflp_dev.rest_escola.academico.instituicao;

import com.github.luisflp_dev.rest_escola.academico.curso.Curso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "instituicao")
@Getter
@Setter
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instituicao")
    private Long idInstituicao;

    @Column(name = "tx_sigla", length = 15,nullable = false, unique = true)
    private String sigla;

    @Column(name = "tx_descricao", length = 150, nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "instituicao", fetch = FetchType.LAZY)
    private Set<Curso> cursos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instituicao)) return false;

        Instituicao other = (Instituicao) o;

        return idInstituicao != null && idInstituicao.equals(other.getIdInstituicao());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
