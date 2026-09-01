package com.github.luisflp_dev.rest_escola.pessoa.aluno;

import java.time.LocalDate;

import com.github.luisflp_dev.rest_escola.pessoa.Sexo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "aluno")
@Getter
@Setter
public class Aluno {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id_aluno")
    private Long idAluno;

    @Column(name= "tx_nome",length = 100, nullable= false)
    private String nome;


    @Column(name= "tx_sexo", length= 1, nullable= false)
    private Sexo sexo;

    @Column(name = "dt_nascimento", nullable= false)
    private LocalDate dataNascimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;

        Aluno other = (Aluno) o;

        return idAluno != null && idAluno.equals(other.getIdAluno());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

}
