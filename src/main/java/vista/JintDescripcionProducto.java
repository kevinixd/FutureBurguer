/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author javam2019
 */
public class JintDescripcionProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form JintDescripcionProducto
     */
    public JintDescripcionProducto() {
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

        jLblImgProducto = new javax.swing.JLabel();
        jLblNombreProducto = new javax.swing.JLabel();
        jLblPrecioCombo = new javax.swing.JLabel();
        jLblDescpProducto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCmbTamanioProducto = new javax.swing.JComboBox<>();
        JBtnRegresarProduc = new javax.swing.JButton();
        jBtnAñadirProduc = new javax.swing.JButton();
        jLblWarningProducto = new javax.swing.JLabel();
        JlblAdvertencia = new javax.swing.JLabel();
        jBtnMas = new javax.swing.JButton();
        jBtnMenos = new javax.swing.JButton();
        jTxtCantidad = new javax.swing.JTextField();
        Cantidad = new javax.swing.JLabel();

        jLblNombreProducto.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jLblNombreProducto.setText("Nombre Producto");

        jLblPrecioCombo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLblPrecioCombo.setText("Precio");

        jLblDescpProducto.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLblDescpProducto.setText("Descripción");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("Tamaño:");

        jCmbTamanioProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jCmbTamanioProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JBtnRegresarProduc.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        JBtnRegresarProduc.setText("Regresar");

        jBtnAñadirProduc.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jBtnAñadirProduc.setText("Añadir a la orden");

        jLblWarningProducto.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        jLblWarningProducto.setForeground(new java.awt.Color(255, 0, 0));
        jLblWarningProducto.setText("!El producto solo cuenta con un tamaño¡");

        JlblAdvertencia.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        JlblAdvertencia.setForeground(new java.awt.Color(0, 153, 0));
        JlblAdvertencia.setText("*");

        jBtnMas.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jBtnMas.setText("+");

        jBtnMenos.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jBtnMenos.setText("-");

        jTxtCantidad.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jTxtCantidad.setText("1");

        Cantidad.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Cantidad.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblImgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblNombreProducto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblPrecioCombo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JlblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(Cantidad))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnMenos)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jBtnMas))))))
                    .addComponent(jLblDescpProducto)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCmbTamanioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLblWarningProducto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBtnRegresarProduc)
                        .addGap(74, 74, 74)
                        .addComponent(jBtnAñadirProduc)
                        .addGap(176, 176, 176)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblImgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblNombreProducto)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblPrecioCombo)
                            .addComponent(JlblAdvertencia)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cantidad)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnMenos)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBtnMas))))))
                .addGap(12, 12, 12)
                .addComponent(jLblDescpProducto)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCmbTamanioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLblWarningProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBtnRegresarProduc)
                    .addComponent(jBtnAñadirProduc))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Cantidad;
    public javax.swing.JButton JBtnRegresarProduc;
    public javax.swing.JLabel JlblAdvertencia;
    public javax.swing.JButton jBtnAñadirProduc;
    public javax.swing.JButton jBtnMas;
    public javax.swing.JButton jBtnMenos;
    public javax.swing.JComboBox<String> jCmbTamanioProducto;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLblDescpProducto;
    public javax.swing.JLabel jLblImgProducto;
    public javax.swing.JLabel jLblNombreProducto;
    public javax.swing.JLabel jLblPrecioCombo;
    public javax.swing.JLabel jLblWarningProducto;
    public javax.swing.JTextField jTxtCantidad;
    // End of variables declaration//GEN-END:variables
}
