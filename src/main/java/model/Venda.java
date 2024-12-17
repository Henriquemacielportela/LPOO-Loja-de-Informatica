/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author henrique
 */
@Entity
@Table(name = "tb_vendas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Venda implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;
    
    public Venda(){
        cliente = null;
    }
    
    public Venda(Cliente cli){
        this.cliente = cli;
        data = new Date();
    }
    
    @Column(nullable = false)
    private Double valor_Total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }
   

    public Double getValor_Total() {
        return valor_Total;
    }

    public void setValor_Total(Double valor_Total) {
        this.valor_Total = valor_Total;
    }
    
    @Override
    public String toString(){
        return cliente != null ? cliente.getNome() :"";
    }
}
