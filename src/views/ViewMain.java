/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Briceyda Angeles
 */
public class ViewMain extends javax.swing.JFrame {

    /**
     * Creates new form View_Menu
     */
    public ViewMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmi_iniciarsesion = new javax.swing.JMenu();
        jmi_iniciar_sesion = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmi_usuarios = new javax.swing.JMenuItem();
        jmi_menu = new javax.swing.JMenu();
        jmi_clientes = new javax.swing.JMenuItem();
        jmi_renta = new javax.swing.JMenuItem();
        jmi_asistencia = new javax.swing.JMenuItem();
        jmi_membrecias = new javax.swing.JMenuItem();
        jmi_salir = new javax.swing.JMenuItem();
        jmi_historial = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gym.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 480));

        jmi_iniciarsesion.setText("Iniciar");

        jmi_iniciar_sesion.setText("IniciarSesion");
        jmi_iniciarsesion.add(jmi_iniciar_sesion);

        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmi_iniciarsesion.add(jMenuItem1);

        jmi_usuarios.setText("Usuarios");
        jmi_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_usuariosActionPerformed(evt);
            }
        });
        jmi_iniciarsesion.add(jmi_usuarios);

        jMenuBar1.add(jmi_iniciarsesion);

        jmi_menu.setText("Menu");

        jmi_clientes.setText("Clientes");
        jmi_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_clientesActionPerformed(evt);
            }
        });
        jmi_menu.add(jmi_clientes);

        jmi_renta.setText("Rentas de Locker");
        jmi_menu.add(jmi_renta);

        jmi_asistencia.setText("Asistencias");
        jmi_asistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_asistenciaActionPerformed(evt);
            }
        });
        jmi_menu.add(jmi_asistencia);

        jmi_membrecias.setText("Membrecias");
        jmi_menu.add(jmi_membrecias);

        jmi_salir.setText("Salir");
        jmi_menu.add(jmi_salir);

        jMenuBar1.add(jmi_menu);

        jmi_historial.setText("Historial");
        jMenuBar1.add(jmi_historial);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmi_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_usuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_usuariosActionPerformed

    private void jmi_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_clientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_clientesActionPerformed

    private void jmi_asistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_asistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_asistenciaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jmi_asistencia;
    public javax.swing.JMenuItem jmi_clientes;
    public javax.swing.JMenu jmi_historial;
    public javax.swing.JMenuItem jmi_iniciar_sesion;
    public javax.swing.JMenu jmi_iniciarsesion;
    public javax.swing.JMenuItem jmi_membrecias;
    public javax.swing.JMenu jmi_menu;
    public javax.swing.JMenuItem jmi_renta;
    public javax.swing.JMenuItem jmi_salir;
    public javax.swing.JMenuItem jmi_usuarios;
    // End of variables declaration//GEN-END:variables
}