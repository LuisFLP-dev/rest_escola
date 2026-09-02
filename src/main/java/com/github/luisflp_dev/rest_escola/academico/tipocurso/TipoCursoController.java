package com.github.luisflp_dev.rest_escola.academico.tipocurso;

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
@RequestMapping("/tipo-curso")
@RequiredArgsConstructor
public class TipoCursoController {

    private final TipoCursoService tipoCursoService;

    @GetMapping
    private ResponseEntity<Page<TipoCursoResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "descricao", direction = Sort.Direction.DESC)Pageable pageable
            ){
        return ResponseEntity.ok(tipoCursoService.listAll(pageable));
    }

    @GetMapping("/{idTipoCurso}")
    public ResponseEntity<TipoCursoResponseDTO> getById(
            @PathVariable Integer idTipoCurso
    ){
        return ResponseEntity.ok(tipoCursoService.getById(idTipoCurso));
    }

    @PostMapping
    public ResponseEntity<TipoCursoResponseDTO> create(
            @RequestBody @Valid TipoCursoRequestDTO tipoCursoDTO
    ){
        TipoCursoResponseDTO created = tipoCursoService.create(tipoCursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idTipoCurso}")
    public ResponseEntity<TipoCursoResponseDTO> update(
            @PathVariable Integer idTipoCurso,
            @RequestBody @Valid TipoCursoRequestDTO tipoCursoDTO
    ){
        return ResponseEntity.ok(tipoCursoService.update(idTipoCurso, tipoCursoDTO));
    }

    @DeleteMapping("/{idTipoCurso}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idTipoCurso
    ){
        tipoCursoService.delete(idTipoCurso);
        return ResponseEntity.noContent().build();
    }
}
