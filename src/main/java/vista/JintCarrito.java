/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static controlador.PrincipalControlador.principal;

/**
 *
 * @author qobis
 */
public class JintCarrito extends javax.swing.JInternalFrame {

    /**
     * Creates new form JintCarrito
     */
    public JintCarrito() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
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
        jTlbCarrito = new javax.swing.JTable();
        jBtnOrdenar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLblTotal1 = new javax.swing.JLabel();
        jLblTotal2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1500, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTlbCarrito = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTlbCarrito.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jTlbCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTlbCarrito.setCellSelectionEnabled(true);
        jTlbCarrito.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jTlbCarrito.setRowHeight(60);
        jTlbCarrito.getTableHeader().setResizingAllowed(false);
        jTlbCarrito.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTlbCarrito);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 59, 1321, 480));

        jBtnOrdenar.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jBtnOrdenar.setText("Ordenar");
        jBtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOrdenarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 637, 176, -1));

        jBtnCancelar.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jBtnCancelar.setText("Cancelar Orden");
        getContentPane().add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 637, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Carrito de compras");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 6, -1, -1));

        jLblTotal.setFont(new java.awt.Font("Dialog", 3, 32)); // NOI18N
        jLblTotal.setText("Q.123456");
        getContentPane().add(jLblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 550, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jLabel3.setText("Total: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 550, -1, -1));

        jLblTotal1.setFont(new java.awt.Font("Dialog", 3, 32)); // NOI18N
        jLblTotal1.setText("________");
        getContentPane().add(jLblTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 560, 160, -1));

        jLblTotal2.setFont(new java.awt.Font("Dialog", 3, 32)); // NOI18N
        jLblTotal2.setText("________");
        getContentPane().add(jLblTotal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 550, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOrdenarActionPerformed
        JintCliente cliente = new JintCliente();
        principal.EscritorioPrincipal.add(cliente);
        cliente.setVisible(true);
    }//GEN-LAST:event_jBtnOrdenarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnCancelar;
    public javax.swing.JButton jBtnOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLblTotal;
    private javax.swing.JLabel jLblTotal1;
    private javax.swing.JLabel jLblTotal2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTlbCarrito;
    // End of variables declaration//GEN-END:variables
}
