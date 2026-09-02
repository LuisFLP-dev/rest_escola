package com.github.luisflp_dev.rest_escola.academico.titulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Integer> {
}
