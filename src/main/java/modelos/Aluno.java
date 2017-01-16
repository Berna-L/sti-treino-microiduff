/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.NullArgumentException;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class Aluno {
    
    @Printable(posicao=0)
    private final String nome;
    
//    @Printable(posicao=2)
//    private final String curso;
    
    @Printable(posicao=1)
    private final String matricula;
    
//    @Printable(posicao=3)
//    private final String localidade;
//    
//    @Printable(posicao=4)
//    private final Turno turno;
//    
//    @Printable(posicao=5)
//    private final String anoSemestreIngresso;
    private final List<Historico> historico;
    
    @Printable(posicao=6)
    private float cr;

    public Aluno(String nome, String curso, String matricula, String localidade, Turno turno, String anoSemestreIngresso) {
        this.nome = nome;
//        this.curso = curso;
        this.matricula = matricula;
//        this.localidade = localidade;
//        this.turno = turno;
//        this.anoSemestreIngresso = anoSemestreIngresso;
        this.historico = new ArrayList<>();
        this.cr = 0.0f;
    }

    @Override
    public String toString(){
        List<String> strArray = new ArrayList<>();
        for(Field field : Aluno.class.getDeclaredFields()){
            if(field.isAnnotationPresent(Printable.class)){
                Printable ann = field.getAnnotation(Printable.class);
                strArray.add(ann.posicao(), field.toString());
            }
        }
        String result = "";
        result = strArray.stream().map((piece) -> piece + " ").reduce(result, String::concat);
        return result.trim();
    }
    
//    public String getCurso() {
//        return curso;
//    }
//
//    public String getLocalidade() {
//        return localidade;
//    }
//
//    public Turno getTurno() {
//        return turno;
//    }
//
//    public String getAnoSemestreIngresso() {
//        return anoSemestreIngresso;
//    }
    
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
