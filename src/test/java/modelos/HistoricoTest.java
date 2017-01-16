/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class HistoricoTest {
    
    @BeforeClass
    public static void setUp(){
        FixtureFactoryLoader.loadTemplates("template");
        
    }
    
    @Test
    public void fixtureHistorico(){
        Historico h = Fixture.from(Historico.class).gimme("valido");
        assertNotNull("Historico nao pode ser nulo", h);
        assertTrue(h.getNota() <= 100 && h.getNota() >= 0);
    }
}
