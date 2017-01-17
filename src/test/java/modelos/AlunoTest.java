/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import java.util.List;
import org.apache.commons.math.exception.NullArgumentException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class AlunoTest {
    
    @BeforeClass
    public static void setUp(){
        FixtureFactoryLoader.loadTemplates("template");
    }

    @Test
    public void fixtureAluno(){
        Aluno aluno = Fixture.from(Aluno.class).gimme("valido");
        assertNotNull("Aluno não pode ser nulo", aluno);
        assertNotNull("Histórico não pode ser nulo", aluno.getHistorico());
        assertEquals(10, aluno.getHistorico().size());
    }

    @Test
    public void appendHistoricoFunciona(){
        Historico h = mock(Historico.class);
        Aluno aluno = Fixture.from(Aluno.class).gimme("valido");
        int tamanhoAnterior = aluno.getHistorico().size();
        aluno.appendHistorico(h);
        assertEquals(tamanhoAnterior + 1, aluno.getHistorico().size());
    }

    @Test(expected = NullPointerException.class)
    public void appendHistoricoComNuloDaErro(){
        Aluno aluno = Fixture.from(Aluno.class).gimme("valido");
        aluno.appendHistorico(null);
    }
 
    @Test
    public void historicoDeAlunoImutavel(){
        Aluno aluno = Fixture.from(Aluno.class).gimme("valido");
        List<Historico> h = aluno.getHistorico();
        h.add(mock(Historico.class));
        assertNotEquals(h, aluno.getHistorico());
    }
 
    @Test
    public void imprimeCorretamente(){
        Aluno aluno = Fixture.from(Aluno.class).gimme("valido");
        String expected = aluno.getNome()
                + " " + aluno.getCurso().toString()
                + " " + aluno.getMatricula()
                + " " +aluno.getLocalidade().toString()
                + " " + aluno.getTurno().toString()
                + " " + aluno.getAnoSemestreIngresso()
                + " " + aluno.getCr();
        String str = aluno.toString();
        assertEquals(expected, aluno.toString());
    }
}
