package template;

import modelos.Historico;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.six2six.fixturefactory.Rule;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class HistoricoTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Historico.class).addTemplate("valido", new Rule() {{
            add("disciplina", regex("TCC00\\d{3}"));
            add("periodo", regex("201[0-6]][1-2]"));
            add("nota", random(Integer.class, range(0, 100)));
        }}).addTemplate("nota7", new Rule() {{
            add("disciplina", regex("TCC00\\d{3}"));
            add("periodo", regex("201[0-6]][1-2]"));
            add("nota", 7);
        }});
    }
}
