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
public class jIntCIH4 extends javax.swing.JInternalFrame {

    /**
     * Creates new form jIntComboIndividualHamburguesas
     */
    public jIntCIH4() {
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

        jBtnIH4 = new javax.swing.JButton();
        jBtnCH4 = new javax.swing.JButton();
        jLblCH4 = new javax.swing.JLabel();
        jLblPrecioC4 = new javax.swing.JLabel();
        jLblIH4 = new javax.swing.JLabel();
        jLblPrecioI4 = new javax.swing.JLabel();

        jBtnIH4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIH4ActionPerformed(evt);
            }
        });

        jBtnCH4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCH4ActionPerformed(evt);
            }
        });

        jLblCH4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLblCH4.setText("Combo");

        jLblPrecioC4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLblPrecioC4.setText("Q50.00");

        jLblIH4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLblIH4.setText("Individual");

        jLblPrecioI4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLblPrecioI4.setText("Q20.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnCH4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnIH4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblCH4)
                            .addComponent(jLblPrecioC4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLblPrecioI4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jLblIH4)))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jBtnCH4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCH4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblPrecioC4)
                .addGap(46, 46, 46)
                .addComponent(jBtnIH4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblIH4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblPrecioI4)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIH4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIH4ActionPerformed

    }//GEN-LAST:event_jBtnIH4ActionPerformed

    private void jBtnCH4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCH4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCH4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnCH4;
    public javax.swing.JButton jBtnIH4;
    private javax.swing.JLabel jLblCH4;
    private javax.swing.JLabel jLblIH4;
    private javax.swing.JLabel jLblPrecioC4;
    private javax.swing.JLabel jLblPrecioI4;
    // End of variables declaration//GEN-END:variables
}