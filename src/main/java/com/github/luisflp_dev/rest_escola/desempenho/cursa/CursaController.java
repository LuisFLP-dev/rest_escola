package com.github.luisflp_dev.rest_escola.desempenho.cursa;


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
@RequestMapping("/cursa")
@RequiredArgsConstructor
public class CursaController {

    private final CursaService cursaService;

    @GetMapping
    public ResponseEntity<Page<CursaResponseDTO>> getAll(
            @PageableDefault(size = 15, sort = "id.ano", direction = Sort.Direction.DESC)Pageable pageable
            ){
        return ResponseEntity.ok(cursaService.listAll(pageable));
    }

    @GetMapping("/{idAluno}/{idDisciplina}/{ano}/{semestre}")
    public ResponseEntity<CursaResponseDTO> getById(
            @PathVariable Integer idAluno,
            @PathVariable Integer idDisciplina,
            @PathVariable Integer ano,
            @PathVariable Integer semestre
    ){
        return ResponseEntity.ok(cursaService.getById(idAluno,idDisciplina,ano,semestre));
    }

    @PostMapping
    public ResponseEntity<CursaResponseDTO> create(@RequestBody @Valid CursaRequestDTO cursaDTO){
        CursaResponseDTO created = cursaService.create(cursaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{idAluno}/{idDisciplina}/{ano}/{semestre}")
    public ResponseEntity<CursaResponseDTO> update(
            @PathVariable Integer idAluno,
            @PathVariable Integer idDisciplina,
            @PathVariable Integer ano,
            @PathVariable Integer semestre,
            @RequestBody @Valid CursaRequestDTO cursaDTO
    ){
        return ResponseEntity.ok(cursaService.update(idAluno,idDisciplina,ano,semestre,cursaDTO));
    }

    @DeleteMapping("/{idAluno}/{idDisciplina}/{ano}/{semestre}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idAluno,
            @PathVariable Integer idDisciplina,
            @PathVariable Integer ano,
            @PathVariable Integer semestre
    ){
        cursaService.delete(idAluno,idDisciplina,ano,semestre);
        return ResponseEntity.noContent().build();
    }


}
