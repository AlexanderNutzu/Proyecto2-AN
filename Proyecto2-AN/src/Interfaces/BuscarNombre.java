/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import Funciones.Validar;
import static Interfaces.Iniciar.gestionApp;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
public class BuscarNombre extends javax.swing.JFrame {

    private Validar validar = new Validar();
    private Lista resultados = new Lista();
    
    public BuscarNombre() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoBusqueda = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        inputIndex = new javax.swing.JTextField();
        verDescendencia = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busqueda Por Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 540, -1));

        jLabel2.setText("Ingrese el nombre de la persona:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });
        jPanel1.add(inputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 280, -1));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        resultadoBusqueda.setColumns(20);
        resultadoBusqueda.setRows(5);
        jScrollPane1.setViewportView(resultadoBusqueda);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 280, 180));

        jLabel3.setText("Numero asociado a a persona para ver su descendencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        inputIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIndexActionPerformed(evt);
            }
        });
        jPanel1.add(inputIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 280, -1));

        verDescendencia.setText("Ver descendencia");
        verDescendencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDescendenciaActionPerformed(evt);
            }
        });
        jPanel1.add(verDescendencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String nombreBusq = inputNombre.getText();
        resultados = gestionApp.getTablaPersonas().buscarNombreUnico(nombreBusq);
        resultadoBusqueda.setText(gestionApp.mostrarBusquedaNombreUnico(resultados));
    }//GEN-LAST:event_buscarActionPerformed

    private void inputIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIndexActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void verDescendenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDescendenciaActionPerformed
        String indexStr = inputIndex.getText();
        if(validar.convertirNumero(indexStr) != -1){
            int index = validar.convertirNumero(indexStr);
            if(validar.indexResultadoValido(resultados, index)){
                JOptionPane.showMessageDialog(null, gestionApp.buscarIndex(resultados, index));
            }else{
                JOptionPane.showMessageDialog(null, "El indice no concuerda con ningun indice entre los resultados obtenidos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Solo se admiten enteros");
        }
    }//GEN-LAST:event_verDescendenciaActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarNombre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField inputIndex;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultadoBusqueda;
    private javax.swing.JButton verDescendencia;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
