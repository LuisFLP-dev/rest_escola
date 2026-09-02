package com.github.luisflp_dev.rest_escola.pessoa.aluno;

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
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Page<AlunoResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "nome", direction = Sort.Direction.DESC) Pageable pageable
    ){
        return ResponseEntity.ok(alunoService.listAll(pageable));
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<AlunoResponseDTO> getById(
            @PathVariable Integer idAluno
    ){
        return ResponseEntity.ok(alunoService.getById(idAluno));
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> create(
            @RequestBody @Valid AlunoRequestDTO alunoDTO
    ){
       AlunoResponseDTO created = alunoService.create(alunoDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idAluno}")
    public ResponseEntity<AlunoResponseDTO> update(
            @PathVariable Integer idAluno,
            @RequestBody @Valid AlunoRequestDTO alunoDTO
    ){
        return ResponseEntity.ok(alunoService.update(idAluno, alunoDTO));
    }

    @DeleteMapping("/{idAluno}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idAluno
    ){
        alunoService.delete(idAluno);
        return ResponseEntity.noContent().build();
    }
}
