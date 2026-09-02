package com.github.luisflp_dev.rest_escola.academico.titulo;

import java.util.Set;

import com.github.luisflp_dev.rest_escola.pessoa.professor.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "titulo")
@Getter
@Setter
public class Titulo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id_titulo")
    private Integer idTitulo;

    @Column(name= "tx_descricao",length= 150 , unique= true, nullable= false)
    private String descricao;

    @OneToMany(mappedBy= "titulo", fetch= FetchType.LAZY)
    private Set<Professor> professores;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Titulo)) return false;

        Titulo other = (Titulo) o;

        return idTitulo != null && idTitulo.equals(other.getIdTitulo());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
    
}
