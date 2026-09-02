package com.github.luisflp_dev.rest_escola.pessoa.professor;

import java.time.LocalDate;
import java.util.Set;

import com.github.luisflp_dev.rest_escola.academico.disciplina.Disciplina;
import com.github.luisflp_dev.rest_escola.academico.titulo.Titulo;
import com.github.luisflp_dev.rest_escola.pessoa.Sexo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "professor")
@Getter
@Setter
public class Professor {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id_professor")
    private Integer idProfessor;

    @ManyToOne(fetch= FetchType.LAZY, optional= false)
    @JoinColumn(name= "id_titulo", nullable= false)
    private Titulo titulo;

    @ManyToMany
    @JoinTable(
            name = "leciona",
            joinColumns = @JoinColumn(name = "id_professor"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina")
    )
    private Set<Disciplina> disciplinas;

    @Column(name= "tx_nome",length= 50 , nullable= false)
    private String nome;

    @Column(name= "tx_sexo", length= 1, columnDefinition = "bpchar", nullable= false)
    private Sexo sexo;

    @Column(name= "tx_estado_civil", length= 1, columnDefinition = "bpchar",nullable= false)
    private EstadoCivil estadoCivil;

    @Column(name = "dt_nascimento", nullable= false)
    private LocalDate dataNascimento;
    
    @Column(name= "tx_telefone",length= 13 , nullable= false)
    private String telefone;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;

        Professor other = (Professor) o;

        return idProfessor != null && idProfessor.equals(other.getIdProfessor());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
