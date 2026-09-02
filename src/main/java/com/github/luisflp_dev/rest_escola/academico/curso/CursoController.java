package com.github.luisflp_dev.rest_escola.academico.curso;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<Page<CursoResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "descricao", direction = Sort.Direction.DESC)Pageable pageable
    ){
        return ResponseEntity.ok(cursoService.listAll(pageable));
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoResponseDTO> getById(
            @PathVariable Integer idCurso
    ){
        return ResponseEntity.ok(cursoService.getById(idCurso));
    }

    @PostMapping
    public ResponseEntity<CursoResponseDTO> create(
            @RequestBody @Valid CursoRequestDTO cursoDTO
    ){
        CursoResponseDTO created = cursoService.create(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idCurso}")
    public ResponseEntity<CursoResponseDTO> update(
            @PathVariable Integer idCurso,
            @RequestBody @Valid CursoRequestDTO cursoDTO
    ){
        return ResponseEntity.ok(cursoService.update(idCurso, cursoDTO));
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idCurso
    ){
        cursoService.delete(idCurso);
        return ResponseEntity.noContent().build();
    }
}