
import henrique.loja_de_informatica.dao.PersistenciaJPA;
import model.Cliente;
import model.Funcionario;
import model.Tipo_Cliente;
import model.Tipo_Funcionario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henrique
 */
public class Teste_Persistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public Teste_Persistencia() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    @Test
    public void teste_Persistencia(){
        Cliente c = new Cliente();
        c.setNome("Pedro");
        c.setEmail("pedro@gmail.com");
        c.setFone("9999999999");
        c.setTipo_Cliente(Tipo_Cliente.FISICA);
//        
//        Cliente c1 = new Cliente();
//        c1.setNome("Maria");
//        c1.setEmail("maria@gmail.com");
//        c1.setFone("66666666666");
//        c1.setTipo_Cliente(Tipo_Cliente.JURIDICA);

        Funcionario f = new Funcionario();
        f.setNome("Joana");
        f.setEmail("joana@gnail.com");
        f.setFone("33333333333");
        f.setTipo_funcionario(Tipo_Funcionario.TECNICO);
        
        try{
            jpa.persist(c);
//            jpa.persist(c1);
            jpa.persist(f);
            
            
        } catch(Exception e){
            System.err.println("Erro ao persistir os dados.");
        }
    }
}
