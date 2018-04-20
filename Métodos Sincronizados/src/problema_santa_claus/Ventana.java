/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema_santa_claus;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

/**
 *
 * @author developer
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    private static SantaClaus santa = new SantaClaus();
    public static DefaultListModel renos;
    public static DefaultListModel elfos;

    private static ArrayList<String> NombresRenos = new ArrayList<String>(
            Arrays.asList("Vondín", "Danzarín", "Chiqui", "Juguetón", "Cometa",
                    "Cupido", "Trueno", "Relámpago", "Rodolfo"));

    public Ventana() {
        initComponents();

        elfos = new DefaultListModel();
        renos = new DefaultListModel();

        listaElfos.setModel(elfos);
        listaRenos.setModel(renos);
        santa.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaElfos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRenos = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        btnReno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listaElfos);

        jScrollPane2.setViewportView(listaRenos);

        jButton1.setText("+ Elfo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElfo(evt);
            }
        });

        btnReno.setText("+ Reno");
        btnReno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReno(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)
                        .addComponent(btnReno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReno)
                    .addComponent(jButton1))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addReno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReno
        // TODO add your handling code here:
        if (renos.size() < NombresRenos.size()) {
            Reno reno = new Reno(santa, NombresRenos.get(renos.size()));
            reno.start();
            renos.addElement(reno);
        }

        if (renos.size() == NombresRenos.size()) {
            btnReno.setEnabled(false);
        }
    }//GEN-LAST:event_addReno

    private void addElfo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElfo
        // TODO add your handling code here:
        Elfo elfo = new Elfo(santa, elfos.size() + 1);
        elfo.start();
        elfos.addElement(elfo);
    }//GEN-LAST:event_addElfo

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReno;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaElfos;
    private javax.swing.JList<String> listaRenos;
    // End of variables declaration//GEN-END:variables
}
