/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package henrique.loja_de_informatica.view;

import henrique.loja_de_informatica.dao.PersistenciaJPA;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Venda;

/**
 *
 * @author henrique
 */
public class Tela_Venda extends javax.swing.JFrame {
    PersistenciaJPA jpa;
    private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form Tela_Venda
     */
    public Tela_Venda() {
        initComponents();
        setTitle("Vendas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jpa = new PersistenciaJPA();
        load_Vendas_Cadastradas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNova_Venda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Vendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_Cliente = new javax.swing.JTextField();
        btn_Remover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNova_Venda.setText("Nova Venda");
        btnNova_Venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNova_VendaActionPerformed(evt);
            }
        });

        tbl_Vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data", "Cliente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Vendas);

        jLabel1.setText("Cliente");

        txt_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ClienteKeyReleased(evt);
            }
        });

        btn_Remover.setText("Remover Venda");
        btn_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(txt_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNova_Venda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Remover))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNova_Venda)
                    .addComponent(btn_Remover))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNova_VendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNova_VendaActionPerformed
        Tela_Cadastro_Venda telaCadastro
                = new Tela_Cadastro_Venda(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);
        load_Vendas_Cadastradas();
    }//GEN-LAST:event_btnNova_VendaActionPerformed

    private void txt_ClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ClienteKeyReleased
        if (txt_Cliente.getText().trim().isEmpty()) {
            load_Vendas_Cadastradas();
        } else {
            jpa.conexaoAberta();

            load_Vendas_Cadastradas(jpa.getVendas(txt_Cliente.getText().trim()));

            jpa.fecharConexao();
        }
    }//GEN-LAST:event_txt_ClienteKeyReleased

    private void btn_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoverActionPerformed
        Venda venda_selecionada = getVendaSel();
        if (venda_selecionada != null) {
            int delOp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover venda do cliente " + venda_selecionada + "?");
            if (delOp == JOptionPane.YES_OPTION){
                try {
                    jpa.conexaoAberta();
                    jpa.remover(venda_selecionada);
                    JOptionPane.showMessageDialog(rootPane, "Venda removida com sucesso!");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Erro ao remover venda " + venda_selecionada + "\nErro: " + e.getMessage());
                } finally {
                    jpa.fecharConexao();
                }
                load_Vendas_Cadastradas();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma venda para remover");
        }
    }//GEN-LAST:event_btn_RemoverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNova_Venda;
    private javax.swing.JButton btn_Remover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Vendas;
    private javax.swing.JTextField txt_Cliente;
    // End of variables declaration//GEN-END:variables

    private void load_Vendas_Cadastradas() {
        jpa.conexaoAberta();
        try {
            List<Venda> lista_vendas = jpa.getVendas();
            DefaultTableModel modeloTabela = (DefaultTableModel) tbl_Vendas.getModel();
            modeloTabela.setRowCount(0);
            for (Venda venda : lista_vendas) {
                Object[] linha = {
                    formatoData.format(venda.getData()),
                    venda,
                    venda.getValor_Total()
                    
                };
                modeloTabela.addRow(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar as vendas aqui: " + e.getMessage());
        } finally {
            jpa.fecharConexao();
        }
    }
    
    private void load_Vendas_Cadastradas(List<Venda> lista_vendas){
        try {
            DefaultTableModel modeloTabela = (DefaultTableModel) tbl_Vendas.getModel();
            modeloTabela.setRowCount(0);
            for (Venda venda : lista_vendas) {
                Object[] linha = {
                    formatoData.format(venda.getData()),
                    venda,
//                    venda.getCliente() != null ? venda.getCliente().getNome() : "",
                    venda.getValor_Total()
                };
                modeloTabela.addRow(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar as vendas: " + e.getMessage());
        }
    }

    private Venda getVendaSel() {
        int selectedRow = tbl_Vendas.getSelectedRow();
        if (selectedRow != -1) {
            Venda venda = (Venda) tbl_Vendas.getValueAt(selectedRow, 1);
            return venda;
        } else {
            JOptionPane.showMessageDialog(Tela_Venda.this, "Não há venda selecionada.");
            return null;
        }
    }
    
    
}
