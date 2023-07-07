package com.alunoonline.v1.secretaria.services;

import com.alunoonline.v1.secretaria.models.Aluno;
import com.alunoonline.v1.secretaria.repositories.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno updateAluno(Long id,Aluno alunoAtt){
        Aluno aluno = repository.findById(id).get();
        BeanUtils.copyProperties(alunoAtt, aluno, "id");
        Aluno alunoAtualizado = repository.save(aluno);
        return alunoAtualizado;
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
