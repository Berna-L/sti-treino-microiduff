/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
    
    private final String matricula;
    
    private final List<Historico> historico;
    
    private float cr;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.historico = new ArrayList<>();
        this.cr = 0.0f;
    }

    @Printable(posicao=0)
    public String getNome() {
        return nome;
    }

    @Printable(posicao=1)
    public String getMatricula() {
        return matricula;
    }

    public List<Historico> getHistorico() {
        return new ArrayList<>(this.historico);
    }

    @Printable(posicao=2)
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
