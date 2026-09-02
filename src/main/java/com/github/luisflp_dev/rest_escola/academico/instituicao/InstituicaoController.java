package com.github.luisflp_dev.rest_escola.academico.instituicao;

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
@RequestMapping("/instituicao")
@RequiredArgsConstructor
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    @GetMapping
    public ResponseEntity<Page<InstituicaoResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "descricao", direction = Sort.Direction.DESC)Pageable pageable
    ){
        return ResponseEntity.ok(instituicaoService.listAll(pageable));
    }

    @GetMapping("/{idInstituicao}")
    public ResponseEntity<InstituicaoResponseDTO> getById(
            @PathVariable Integer idInstituicao
    ){
        return ResponseEntity.ok(instituicaoService.getById(idInstituicao));
    }

    @PostMapping
    public ResponseEntity<InstituicaoResponseDTO> create(
            @RequestBody @Valid InstituicaoRequestDTO instituicaoDTO
    ){
        InstituicaoResponseDTO created = instituicaoService.create(instituicaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idInstituicao}")
    public ResponseEntity<InstituicaoResponseDTO> update(
            @PathVariable Integer idInstituicao,
            @RequestBody @Valid InstituicaoRequestDTO instituicaoDTO
    ){
        return ResponseEntity.ok(instituicaoService.update(idInstituicao, instituicaoDTO));
    }

    @DeleteMapping("/{idInstituicao}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idInstituicao
    ){
        instituicaoService.delete(idInstituicao);
        return ResponseEntity.noContent().build();
    }
}