package com.github.luisflp_dev.rest_escola.academico.disciplina;

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
@RequestMapping("/disciplina")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<Page<DisciplinaResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "descricao", direction = Sort.Direction.DESC)Pageable pageable
    ){
        return ResponseEntity.ok(disciplinaService.listAll(pageable));
    }

    @GetMapping("/{idDisciplina}")
    public ResponseEntity<DisciplinaResponseDTO> getById(
            @PathVariable Integer idDisciplina
    ){
        return ResponseEntity.ok(disciplinaService.getById(idDisciplina));
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> create(
            @RequestBody @Valid DisciplinaRequestDTO disciplinaDTO
    ){
        DisciplinaResponseDTO created = disciplinaService.create(disciplinaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idDisciplina}")
    public ResponseEntity<DisciplinaResponseDTO> update(
            @PathVariable Integer idDisciplina,
            @RequestBody @Valid DisciplinaRequestDTO disciplinaDTO
    ){
        return ResponseEntity.ok(disciplinaService.update(idDisciplina, disciplinaDTO));
    }

    @DeleteMapping("/{idDisciplina}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idDisciplina
    ){
        disciplinaService.delete(idDisciplina);
        return ResponseEntity.noContent().build();
    }
}