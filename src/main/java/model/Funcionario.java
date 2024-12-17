/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
@DiscriminatorValue("FUNCIONARIO")
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {
    
    @Enumerated(EnumType.STRING)
    private Tipo_Funcionario tipo_funcionario;
//
//    public Funcionario() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//    
//    
//    
////    @Override
////    public int hashCode() {
////        int hash = 3;
////        hash = 79 * hash + this.id;
////        hash = 79 * hash + Objects.hashCode(this.nome);
////        return hash;
////    }
////
////    @Override
////    public boolean equals(Object obj) {
////        if (this == obj) {
////            return true;
////        }
////        if (obj == null) {
////            return false;
////        }
////        if (getClass() != obj.getClass()) {
////            return false;
////        }
////        final Funcionario other = (Funcionario) obj;
////        if (this.id != other.id) {
////            return false;
////        }
////        return Objects.equals(this.nome, other.nome);
////    }
//
////    public int getId() {
////        return id;
////    }
//

    public Tipo_Funcionario getTipo_funcionario() {
        return tipo_funcionario;
    }

    public void setTipo_funcionario(Tipo_Funcionario tipo_funcionario) {
        this.tipo_funcionario = tipo_funcionario;
    }
    
}