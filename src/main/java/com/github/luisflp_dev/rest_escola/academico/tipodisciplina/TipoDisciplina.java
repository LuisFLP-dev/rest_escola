package com.github.luisflp_dev.rest_escola.academico.tipodisciplina;

import com.github.luisflp_dev.rest_escola.academico.disciplina.Disciplina;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tipo_disciplina")
@Getter
@Setter
public class TipoDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_disciplina")
    private Integer idTipoDisciplina;

    @Column(name = "tx_descricao", length = 150, nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "tipoDisciplina",fetch = FetchType.LAZY)
    private Set<Disciplina> disciplinas;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDisciplina)) return false;

        TipoDisciplina other = (TipoDisciplina) o;

        return idTipoDisciplina != null && idTipoDisciplina.equals(other.getIdTipoDisciplina());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
