 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package henrique.loja_de_informatica.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Venda;

/**
 *
 * @author henrique
 */
public class PersistenciaJPA implements InterfaceBD {
    
    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("loja_de_informatica");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }
    
    
    
    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir a entidade: " + o.getClass().getSimpleName(), e);
            e.printStackTrace(); // Isso imprimirá o erro completo no console
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Garantir que o objeto está no contexto de persistência
            }
            entity.remove(o); // Remover o objeto
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover entidade: " + o.getClass().getSimpleName());
            e.printStackTrace();
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    private EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    public List<Cliente> getClientes() {
        entity = getEntityManager();

        try {
            TypedQuery<Cliente> query = entity.createQuery("Select p from Cliente p", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Clientes: " + e);
            return null;
        }

    }
    public List<Cliente> getClientes(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Cliente> query
                    = entity.createQuery("Select p from Cliente p where lower(p.nome) LIKE :n",
                            Cliente.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Clientes: " + e);
            return null;
        }

    }

    public Cliente find_Cliente_by_id(int id) {
        EntityManager em = getEntityManager();
        Cliente cliente = null;
        
        try {
            em.getTransaction().begin();
            cliente = em.createQuery("SELECT v FROM Cliente v WHERE v.id = :id", Cliente.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com o id: " + id);
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            em.close();
        }
        return cliente;
    }
    
    public List<Venda> getVendas(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Venda> query
                    = entity.createQuery("Select p from Venda p JOIN p.cliente c where lower(c.nome) LIKE :n",
                            Venda.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar a venda pelo cliente: " + e);
            return null;
        }
    }

    public List<Venda> getVendas() {
        entity = getEntityManager();

        try {
            TypedQuery<Venda> query
                    = entity.createQuery("SELECT v FROM Venda v", Venda.class);       
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Vendas: " + e);
            return null;
        }
    }


}
