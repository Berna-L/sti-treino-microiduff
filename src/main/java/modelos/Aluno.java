/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import enums.Curso;
import enums.Localidade;
import enums.Turno;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.NullArgumentException;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class Aluno {
    
    private final String nome;
    
    private final Curso curso;
    
    private final String matricula;
    
    private final Localidade localidade;
    
    private final Turno turno;
    
    private final List<Historico> historico;
    
    private float cr;

    public Aluno(String nome, Curso curso, String matricula, Localidade localidade, Turno turno) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.localidade = localidade;
        this.turno = turno;
        this.historico = new ArrayList<>();
        this.cr = 0.0f;
    }
    @Printable(posicao=0)
    public String getNome() {
        return nome;
    }
    
    @Printable(posicao=1)
    public Curso getCurso() {
        return curso;
    }

    @Printable(posicao=2)
    public String getMatricula() {
        return matricula;
    }

    @Printable(posicao=3)
    public Localidade getLocalidade() {
        return localidade;
    }
    
    @Printable(posicao=4)
    public Turno getTurno() {
        return turno;
    }
    
    @Printable(posicao=5)
    public String getAnoSemestreIngresso() {
        String ano = "20" + getMatricula().substring(0, 2);
        String semestre = getMatricula().substring(2, 3);
        return ano + "/" + semestre;
    }
  
    public List<Historico> getHistorico() {
        return new ArrayList<>(this.historico);
    }

    @Printable(posicao=6)
    public float getCr() {
        return cr;
    }

    public void setCr(float cr) {
        this.cr = cr;
    }

    public void appendHistorico(Historico instancia){
        if (instancia == null){
            throw new NullPointerException("Histórico nulo!");
        }
        this.historico.add(instancia);
    }

    Class noparams[] = {};
    
    @Override
    public String toString() {
        List<String> str = new ArrayList<>();
        for(Method m : this.getClass().getDeclaredMethods()){
            if(m.isAnnotationPresent(Printable.class)){
                try {
                    str.add(m.getAnnotation(Printable.class).posicao(), (m.invoke(this, new Object[] {})).toString());
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
                    continue;
                }
            }
        }
        String result = "";
        for(String piece : str){
            result += piece + " ";
        }
        return result.trim();
    }
    
}
