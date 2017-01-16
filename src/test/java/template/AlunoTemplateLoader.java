/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import modelos.Aluno;
import modelos.Historico;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import modelos.Curso;
import modelos.Turno;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class AlunoTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Aluno.class).addTemplate("valido", new Rule(){{
            add("nome", name());
//            add("curso", random(Curso.CIENCIA_DA_COMPUTACAO));
            add("matricula", regex("1[10-16][1-2]031\\d{3}"));
//            add("localidade", random("Niterói", "Rio das Ostras"));
//            add("turno", random(Turno.INTEGRAL, Turno.MANHA, Turno.NOITE, Turno.TARDE));
//            add("anoSemestreIngresso", regex("201[0-6]][1-2]"));
            add("historico", has(10).of(Historico.class, "valido"));
        }}).addTemplate("nota7", new Rule(){{
            add("nome", name());
//            add("curso", random(Curso.CIENCIA_DA_COMPUTACAO));
            add("matricula", regex("1[10-16][1-2]031\\d{3}"));
//            add("localidade", random("Niterói", "Rio das Ostras"));
//            add("turno", random(Turno.INTEGRAL, Turno.MANHA, Turno.NOITE, Turno.TARDE));
//            add("anoSemestreIngresso", regex("201[0-6]][1-2]"));
            add("historico", has(2).of(Historico.class, "nota7"));
        }});
    }
    
}
