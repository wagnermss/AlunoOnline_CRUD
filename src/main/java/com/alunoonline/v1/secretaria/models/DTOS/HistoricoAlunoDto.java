package com.alunoonline.v1.secretaria.models.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoDto {
    private String nomeAluno;
    private String cursoAluno;
    private List<DisciplinasAlunoDto> disciplinasAlunoDtoList;

}
