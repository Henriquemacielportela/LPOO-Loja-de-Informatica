/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author henrique
 */
@Entity
@DiscriminatorValue("CLIENTE")
@Table(name = "tb_cliente")
public class Cliente extends Pessoa {
    
    @Enumerated(EnumType.STRING)
    private Tipo_Cliente tipo_Cliente;
    
    @Column(length = 50)
    private String documento;

    
    public Tipo_Cliente getTipo_Cliente() {
        return tipo_Cliente;
    }

    public void setTipo_Cliente(Tipo_Cliente tipo_Cliente) {
        this.tipo_Cliente = tipo_Cliente;
    }
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
   
    @Override
    public String toString() {
        return nome + " -  Tipo: " + tipo_Cliente;
    }

}