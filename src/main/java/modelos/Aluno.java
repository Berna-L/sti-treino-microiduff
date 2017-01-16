/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class Aluno {
    
    private final String nome;
    private final String matricula;
    private final List<Historico> historico;
    private float cr;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.historico = new ArrayList<>();
    }

    public float getCr() {
        return cr;
    }

    public void setCr(float cr) {
        this.cr = cr;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Historico> getHistorico() {
        return new ArrayList<>(this.historico);
    }

    public void appendHistorico(Historico instancia){
        if (instancia == null){
            throw new NullPointerException("Histórico nulo!");
        }
        this.historico.add(instancia);
    }
}
