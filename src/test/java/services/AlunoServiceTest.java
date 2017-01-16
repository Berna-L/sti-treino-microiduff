/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import modelos.Aluno;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public class AlunoServiceTest {
    
    AlunoService service;
    AlunoDAO dao;
        
    @BeforeClass
    public static void setUpTemplate(){
        FixtureFactoryLoader.loadTemplates("template");
    }
    
    @Before
    public void setUp(){
        dao = mock(AlunoDAO.class);
        service = new AlunoService(dao);
    }
    
    @Test
    public void calculaCrCorreto(){
        Aluno expected = Fixture.from(Aluno.class).gimme("nota7");
        when(dao.getAluno(expected.getMatricula())).thenReturn(expected);
        service.calculaCR(expected.getMatricula());
        assertEquals(7.0f, expected.getCr(), 0.01);
        verify(dao).saveAluno(expected);
    }   
}