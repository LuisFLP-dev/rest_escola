package com.github.luisflp_dev.rest_escola.pessoa.professor;

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
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;


    @GetMapping
    public ResponseEntity<Page<ProfessorResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "nome", direction = Sort.Direction.DESC)Pageable pageable
            ){
        return ResponseEntity.ok(professorService.listAll(pageable));

    }

    @GetMapping("/{idProfessor}")
    public ResponseEntity<ProfessorResponseDTO> getById(
            @PathVariable Integer idProfessor
    ){
        return ResponseEntity.ok(professorService.getById(idProfessor));
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> create(
            @RequestBody @Valid ProfessorRequestDTO professorDTO
    ){
        ProfessorResponseDTO created = professorService.create(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idProfessor}")
    public ResponseEntity<ProfessorResponseDTO> update(
            @PathVariable Integer idProfessor,
            @RequestBody @Valid ProfessorRequestDTO professorDTO
    ){
        return ResponseEntity.ok(professorService.update(idProfessor,professorDTO));
    }

    @DeleteMapping("/{idProfessor}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idProfessor
    ){
        professorService.delete(idProfessor);
        return ResponseEntity.noContent().build();
    }
}
