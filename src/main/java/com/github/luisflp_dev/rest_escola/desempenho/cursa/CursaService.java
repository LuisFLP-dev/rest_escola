package com.github.luisflp_dev.rest_escola.desempenho.cursa;

import com.github.luisflp_dev.rest_escola.academico.disciplina.Disciplina;
import com.github.luisflp_dev.rest_escola.academico.disciplina.DisciplinaRepository;
import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import com.github.luisflp_dev.rest_escola.pessoa.aluno.Aluno;
import com.github.luisflp_dev.rest_escola.pessoa.aluno.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.luisflp_dev.rest_escola.exceptions.BusinessRuleException;


@Service
@RequiredArgsConstructor
public class CursaService {

    private final CursaRepository cursaRepository;
    private final CursaMapper cursaMapper;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    @Transactional(readOnly = true)
    public Page<CursaResponseDTO> listAll(Pageable pageable){
        return cursaRepository.findAll(pageable).map(cursaMapper::toDTO);

    }

    @Transactional(readOnly = true)
    public CursaResponseDTO getById(Integer idAluno, Integer idDisciplina, Integer ano, Integer semestre){
        Cursa cursa = findEntityById(idAluno,idDisciplina,ano,semestre);
        return cursaMapper.toDTO(cursa);
    }

    @Transactional
    public CursaResponseDTO create(CursaRequestDTO cursaDTO){
        Aluno aluno = alunoRepository.findById(cursaDTO.idAluno()).orElseThrow(
                () -> new ObjectNotFoundException("Aluno nao encontrado: " + cursaDTO.idAluno())
        );

        Disciplina disciplina = disciplinaRepository.findById(cursaDTO.idDisciplina()).orElseThrow(
                () -> new ObjectNotFoundException("Disciplina nao encontrada: " + cursaDTO.idDisciplina())
        );

        Cursa cursa = cursaMapper.toEntity(cursaDTO);

        CursaId id = new CursaId();
        id.setIdAluno(cursaDTO.idAluno());
        id.setIdDisciplina(cursaDTO.idDisciplina());
        id.setAno(cursaDTO.ano());
        id.setSemestre(cursaDTO.semestre());

        if (cursaRepository.existsById(id)) {
            throw new BusinessRuleException("Aluno já matriculado nesta disciplina para o período informado.");
        }

        cursa.setId(id);

        cursa.setAluno(aluno);
        Cursa saved = cursaRepository.save(cursa);
        return cursaMapper.toDTO(saved);
    }

    @Transactional
    public CursaResponseDTO update(Integer idAluno, Integer idDisciplina, Integer ano, Integer semestre, CursaRequestDTO cursaDTO){
        Cursa cursa = findEntityById(idAluno,idDisciplina,ano,semestre);

        cursa.setFaltas(cursaDTO.faltas());
        cursa.setNota1(cursaDTO.nota1());
        cursa.setNota2(cursaDTO.nota2());
        cursa.setNota3(cursaDTO.nota3());
        cursa.setAprovado(cursaDTO.aprovado());

        Cursa updated = cursaRepository.save(cursa);
        return cursaMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idAluno, Integer idDisciplina, Integer ano, Integer semestre){
        Cursa cursa = findEntityById(idAluno,idDisciplina,ano,semestre);
        cursaRepository.delete(cursa);
    }

    private Cursa findEntityById(Integer idAluno, Integer idDisciplina, Integer ano, Integer semestre){
        CursaId cursa = new CursaId();
        cursa.setIdAluno(idAluno);
        cursa.setIdDisciplina(idDisciplina);
        cursa.setAno(ano);
        cursa.setSemestre(semestre);

        return cursaRepository.findById(cursa).orElseThrow(() -> new ObjectNotFoundException("Resgistro de cursa para o aluno= "+ idAluno + ", disicplina= " + idDisciplina
        + ", ano= " + ano + "e semestre= " + semestre + "nao foram encontrados."));
    }
}
