/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.formularioshamburguesas;

/**
 *
 * @author javam2019
 */
public class jIntOrdenarH1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form jIntOrdenarH1
     */
    public jIntOrdenarH1() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblImgH1 = new javax.swing.JLabel();
        jLblNombreH1 = new javax.swing.JLabel();
        jLblPrecioH1 = new javax.swing.JLabel();
        jLblDescripcionH1 = new javax.swing.JLabel();
        jCmbTamanioH1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jBtnRegresarH1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLblPapaH1 = new javax.swing.JLabel();
        jLblBebidaH1 = new javax.swing.JLabel();
        jLblNombreComboH1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(910, 550));

        jLblNombreH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLblNombreH1.setText("Nombre");

        jLblPrecioH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLblPrecioH1.setText("Precio");

        jLblDescripcionH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLblDescripcionH1.setText("Descripcion");

        jCmbTamanioH1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mediano", "Agrandado" }));

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Añadir a la lista");

        jBtnRegresarH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jBtnRegresarH1.setText("Regresar");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Tamaño:");

        jLblPapaH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLblPapaH1.setText("Papas");

        jLblBebidaH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLblBebidaH1.setText("Bebida");

        jLblNombreComboH1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLblNombreComboH1.setText("Nombre Combo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCmbTamanioH1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLblPapaH1)
                                .addGap(72, 72, 72)
                                .addComponent(jLblBebidaH1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblImgH1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblNombreH1)
                                    .addComponent(jLblPrecioH1)))
                            .addComponent(jLblNombreComboH1)
                            .addComponent(jLblDescripcionH1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jBtnRegresarH1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLblNombreComboH1)
                        .addGap(18, 18, 18)
                        .addComponent(jLblImgH1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLblNombreH1)
                        .addGap(18, 18, 18)
                        .addComponent(jLblPrecioH1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblDescripcionH1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbTamanioH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblPapaH1)
                    .addComponent(jLblBebidaH1))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRegresarH1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnRegresarH1;
    public javax.swing.JButton jButton1;
    public javax.swing.JComboBox<String> jCmbTamanioH1;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLblBebidaH1;
    public javax.swing.JLabel jLblDescripcionH1;
    public javax.swing.JLabel jLblImgH1;
    public javax.swing.JLabel jLblNombreComboH1;
    public javax.swing.JLabel jLblNombreH1;
    public javax.swing.JLabel jLblPapaH1;
    public javax.swing.JLabel jLblPrecioH1;
    // End of variables declaration//GEN-END:variables
}
