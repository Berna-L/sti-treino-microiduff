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
import enums.Curso;
import enums.Localidade;
import enums.Turno;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class AlunoTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Aluno.class).addTemplate("valido", new Rule(){{
            add("nome", name());
            add("curso", Curso.CIENCIA_DA_COMPUTACAO);
            add("matricula", regex("1[0-6][1-2]031\\d{3}"));
            add("localidade", random(Localidade.NITEROI, Localidade.RIO_DAS_OSTRAS));
            add("turno", random(Turno.INTEGRAL, Turno.MANHA, Turno.TARDE));
            add("historico", has(10).of(Historico.class, "valido"));
        }}).addTemplate("nota7", new Rule(){{
            add("nome", name());
            add("curso", Curso.CIENCIA_DA_COMPUTACAO);            
            add("matricula", regex("1[10-16][1-2]031\\d{3}"));
            add("localidade", random(Localidade.NITEROI, Localidade.RIO_DAS_OSTRAS));
            add("turno", random(Turno.INTEGRAL, Turno.MANHA, Turno.TARDE));
            add("historico", has(2).of(Historico.class, "nota7"));
        }});
    }
    
}
