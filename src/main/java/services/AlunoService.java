/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import modelos.Aluno;
import modelos.Historico;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class AlunoService {

    private AlunoDAO alunoDAO;
    
    public AlunoService(AlunoDAO alunoDAO){
        this.alunoDAO = alunoDAO;
    }
    
    public void calculaCR(String matricula){
        Aluno aluno = alunoDAO.getAluno(matricula);
        float cr = 0.0f;
        for(Historico h : aluno.getHistorico()){
            cr += h.getNota();
        }
        cr /= aluno.getHistorico().size();
        aluno.setCr(cr);
        alunoDAO.saveAluno(aluno);
    } 
}
