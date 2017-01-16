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

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class AlunoTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Aluno.class).addTemplate("valido", new Rule(){{
            add("nome", name());
            add("matricula", regex("1[10-16][1-2]031\\d{3}"));
            add("historico", has(10).of(Historico.class, "valido"));
        }}).addTemplate("nota7", new Rule(){{
            add("nome", name());
            add("matricula", regex("1[10-16][1-2]031\\d{3}"));
            add("historico", has(2).of(Historico.class, "nota7"));
        }});
    }
    
}
