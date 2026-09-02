package com.github.luisflp_dev.rest_escola.academico.titulo;

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
@RequestMapping("/titulo")
@RequiredArgsConstructor
public class TituloController {

    private final TituloService tituloService;

    @GetMapping
    public ResponseEntity<Page<TituloResponseDTO>> getAll(
            @PageableDefault( size = 15, sort = "descricao", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.ok(tituloService.listAll(pageable));
    }

    @GetMapping("/{idTitulo}")
    public ResponseEntity<TituloResponseDTO> getById(
            @PathVariable Integer idTitulo
    ){
        return ResponseEntity.ok(tituloService.getById(idTitulo));
    }

    @PostMapping
    public ResponseEntity<TituloResponseDTO> create(
            @RequestBody @Valid TituloRequestDTO tituloDTO
    ){
        TituloResponseDTO created = tituloService.create(tituloDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idTitulo}")
    public ResponseEntity<TituloResponseDTO> update(
            @PathVariable Integer idTitulo,
            @RequestBody @Valid TituloRequestDTO tituloDTO
    ){
        return ResponseEntity.ok(tituloService.update(idTitulo, tituloDTO));
    }

    @DeleteMapping("/{idTitulo}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idTitulo
    ){
        tituloService.delete(idTitulo);
        return ResponseEntity.noContent().build();
    }
}
