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
        jLblPtId = new javax.swing.JLabel();
        jLblPrecioCombo1 = new javax.swing.JLabel();
        jLblTamanio = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLblImgProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 230, 233));

        jLblNombreProducto.setFont(new java.awt.Font("Dialog", 3, 38)); // NOI18N
        jLblNombreProducto.setText("Nombre Producto");
        getContentPane().add(jLblNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLblPrecioCombo.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLblPrecioCombo.setText("Precio");
        getContentPane().add(jLblPrecioCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 108, -1, -1));

        jLblDescpProducto.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLblDescpProducto.setText("Descripción");
        getContentPane().add(jLblDescpProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel5.setText("Tamaño:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, -1, -1));

        jCmbTamanioProducto.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jCmbTamanioProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCmbTamanioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 269, -1));

        JBtnRegresarProduc.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        JBtnRegresarProduc.setText("Regresar");
        getContentPane().add(JBtnRegresarProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, -1, -1));

        jBtnAñadirProduc.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jBtnAñadirProduc.setText("Añadir a la orden");
        getContentPane().add(jBtnAñadirProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 630, -1, -1));

        jLblWarningProducto.setFont(new java.awt.Font("Dialog", 2, 20)); // NOI18N
        jLblWarningProducto.setForeground(new java.awt.Color(255, 0, 0));
        jLblWarningProducto.setText("!El producto solo cuenta con un tamaño¡");
        getContentPane().add(jLblWarningProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, -1, -1));

        JlblAdvertencia.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        JlblAdvertencia.setForeground(new java.awt.Color(0, 153, 0));
        JlblAdvertencia.setText("*");
        getContentPane().add(JlblAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 101, 19, -1));

        jBtnMas.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        jBtnMas.setText("+");
        getContentPane().add(jBtnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 50, -1, -1));

        jBtnMenos.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        jBtnMenos.setText("-");
        getContentPane().add(jBtnMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 50, -1, -1));

        jTxtCantidad.setFont(new java.awt.Font("Dialog", 0, 35)); // NOI18N
        jTxtCantidad.setText("1");
        getContentPane().add(jTxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 50, 40, 50));

        Cantidad.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        Cantidad.setText("Cantidad:");
        getContentPane().add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, -1, -1));

        jLblPtId.setText("ProductoTamanioID");
        getContentPane().add(jLblPtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        jLblPrecioCombo1.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLblPrecioCombo1.setText("Q.");
        getContentPane().add(jLblPrecioCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 108, -1, -1));

        jLblTamanio.setText("Tamanio");
        getContentPane().add(jLblTamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, -1, -1));

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
    public javax.swing.JLabel jLblPrecioCombo1;
    public javax.swing.JLabel jLblPtId;
    public javax.swing.JLabel jLblTamanio;
    public javax.swing.JLabel jLblWarningProducto;
    public javax.swing.JTextField jTxtCantidad;
    // End of variables declaration//GEN-END:variables
}
