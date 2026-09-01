package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursaRepository extends JpaRepository<Cursa, CursaId> {
}
