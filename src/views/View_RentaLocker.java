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
public class View_RentaLocker extends javax.swing.JPanel {

    /**
     * Creates new form RentaLocker
     */
    public View_RentaLocker() {
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

        jbtn_primero = new javax.swing.JButton();
        jbtn_anterior = new javax.swing.JButton();
        jbtn_siguiente = new javax.swing.JButton();
        jbtn_ultimo = new javax.swing.JButton();
        jbtn_editar = new javax.swing.JButton();
        jbtn_agregar = new javax.swing.JButton();
        jbtn_eliminar = new javax.swing.JButton();
        jbtn_nuevo = new javax.swing.JButton();

        jbtn_primero.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_primero.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_primero.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_primero.setText("|<");

        jbtn_anterior.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_anterior.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_anterior.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_anterior.setText("Anterior");

        jbtn_siguiente.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_siguiente.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_siguiente.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_siguiente.setText("Siguiente");

        jbtn_ultimo.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_ultimo.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_ultimo.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_ultimo.setText(">|");

        jbtn_editar.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_editar.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_editar.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_editar.setText("Modificar");

        jbtn_agregar.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_agregar.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_agregar.setText("Agregar");

        jbtn_eliminar.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_eliminar.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_eliminar.setText("Eliminar");

        jbtn_nuevo.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_nuevo.setFont(new java.awt.Font("PakType Naskh Basic", 1, 14)); // NOI18N
        jbtn_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_nuevo.setText("Nuevo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtn_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtn_editar)
                        .addGap(27, 27, 27)
                        .addComponent(jbtn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jbtn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jbtn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(jbtn_nuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_anterior)
                    .addComponent(jbtn_siguiente)
                    .addComponent(jbtn_ultimo)
                    .addComponent(jbtn_primero))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_agregar)
                    .addComponent(jbtn_editar)
                    .addComponent(jbtn_eliminar))
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jbtn_agregar;
    public javax.swing.JButton jbtn_anterior;
    public javax.swing.JButton jbtn_editar;
    public javax.swing.JButton jbtn_eliminar;
    public javax.swing.JButton jbtn_nuevo;
    public javax.swing.JButton jbtn_primero;
    public javax.swing.JButton jbtn_siguiente;
    public javax.swing.JButton jbtn_ultimo;
    // End of variables declaration//GEN-END:variables
}