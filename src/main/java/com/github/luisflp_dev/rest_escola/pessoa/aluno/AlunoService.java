package com.github.luisflp_dev.rest_escola.pessoa.aluno;

import com.github.luisflp_dev.rest_escola.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    @Transactional(readOnly = true)
    public Page<AlunoResponseDTO> listAll(Pageable pageable){
        return alunoRepository.findAll(pageable).map(alunoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public AlunoResponseDTO getById(Integer idAluno){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do aluno com o id: " + idAluno)
        );

        return alunoMapper.toDTO(aluno);
    }

    @Transactional
    public AlunoResponseDTO create(AlunoRequestDTO alunoDTO){

        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        Aluno saved = alunoRepository.save(aluno);

        return alunoMapper.toDTO(saved);

    }

    @Transactional
    public AlunoResponseDTO update (Integer idAluno, AlunoRequestDTO alunoDTO){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do aluno com o id: " + idAluno)
        );

        aluno.setNome(alunoDTO.nome());
        aluno.setSexo(alunoDTO.sexo());
        aluno.setDataNascimento(alunoDTO.dataNascimento());

        Aluno updated = alunoRepository.save(aluno);
        return alunoMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Integer idAluno){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(
                () -> new ObjectNotFoundException("Nao ha registro do aluno com o id: " + idAluno)
        );

        alunoRepository.delete(aluno);
    }

}
