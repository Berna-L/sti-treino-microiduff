/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class Historico {
    
    private final String disciplina;
    private final String periodo;
    private final int nota;
    
    public Historico(String disciplina, String periodo, int nota){
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Histórico{" + "disciplina=" + disciplina + ", periodo=" + periodo + ", nota=" + (nota / 10.0f) + '}';
    }
    
}
