package com.github.luisflp_dev.rest_escola.academico.tipodisciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDisciplinaRepository extends JpaRepository<TipoDisciplina, Integer> {
}
