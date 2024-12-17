/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import henrique.loja_de_informatica.dao.PersistenciaJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author henrique
 */
public class Teste_Conexao {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public Teste_Conexao() {
    }
    
    
    @Before
    public void setUp() {
        if(jpa.conexaoAberta()){
            System.out.println("Conexão aberta");
        } else {
            System.out.println("Erro ao abrir conexao");
        }
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    System.out.println("Conexão realizada com sucesso");
    }
}
