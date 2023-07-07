package com.alunoonline.v1.secretaria.repositories;

import com.alunoonline.v1.secretaria.models.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    List<MatriculaAluno> findByAlunoId(Long alunoId);
}
