package com.github.luisflp_dev.rest_escola.academico.tipodisciplina;

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
@RequestMapping("/tipo-disciplina")
@RequiredArgsConstructor
public class TipoDisciplinaController {

    private final TipoDisciplinaService tipoDisciplinaService;

    @GetMapping
    public ResponseEntity<Page<TipoDisciplinaResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "descricao", direction = Sort.Direction.DESC)Pageable pageable
            ){
        return ResponseEntity.ok(tipoDisciplinaService.listAll(pageable));
    }

    @GetMapping("/{idTipoDisciplina}")
    public ResponseEntity<TipoDisciplinaResponseDTO> getById(
            @PathVariable Integer idTipoDisciplina
    ){
        return ResponseEntity.ok(tipoDisciplinaService.getById(idTipoDisciplina));
    }

    @PostMapping
    public ResponseEntity<TipoDisciplinaResponseDTO> create(
            @RequestBody @Valid TipoDisciplinaRequestDTO tipoDisciplinaDTO
    ){
        TipoDisciplinaResponseDTO created = tipoDisciplinaService.create(tipoDisciplinaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idTipoDisciplina}")
    public ResponseEntity<TipoDisciplinaResponseDTO> update(
            @PathVariable Integer idTipoDisciplina,
            @RequestBody @Valid TipoDisciplinaRequestDTO tipoDisciplinaDTO
    ){
        return ResponseEntity.ok(tipoDisciplinaService.update(idTipoDisciplina, tipoDisciplinaDTO));
    }

    @DeleteMapping("/{idTipoDisciplina}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idTipoDisciplina
    ){
        tipoDisciplinaService.delete(idTipoDisciplina);
        return ResponseEntity.noContent().build();
    }
}
