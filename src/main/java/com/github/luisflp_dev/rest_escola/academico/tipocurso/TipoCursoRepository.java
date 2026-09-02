package com.github.luisflp_dev.rest_escola.academico.tipocurso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCurso, Integer> {
}
