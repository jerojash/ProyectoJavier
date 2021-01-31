package Vista;

import Controller.Control;
import javax.swing.JOptionPane;

public class InstrumentosPrestamo extends javax.swing.JFrame {

    Control control;
    
    public InstrumentosPrestamo() {
        initComponents();
        this.setLocationRelativeTo(null);
        comboDia();
        comboMes();
        comboAnnio();
        control = new Control(Cedula, ID, Dia, Mes, Annio, Profesor, Estudiante);
    }

    private void comboDia(){
        for (int i = 01; i <= 31; i++){
            Dia.addItem(String.valueOf(i));
        }
    }
    
    private void comboMes(){
        for (int i = 01; i <= 12; i++){
            Mes.addItem(String.valueOf(i));
        }
    }
    
    private void comboAnnio(){
        for (int i = 2010; i <= 2021; i++){
            Annio.addItem(String.valueOf(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Dia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Mes = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Annio = new javax.swing.JComboBox<>();
        Cedula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Estudiante = new javax.swing.JRadioButton();
        Profesor = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Préstamo de instrumentos");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(164, 6, 183, 17);

        jLabel2.setText("Ingrese la fecha en la que se hace el préstamo");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(24, 34, 224, 14);

        jLabel6.setText("Ingrese los datos de quien pide el préstamo:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(24, 107, 213, 14);

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel2.add(Volver);
        Volver.setBounds(390, 280, 63, 23);

        Guardar.setText("Realizar préstamo");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel2.add(Guardar);
        Guardar.setBounds(180, 270, 119, 23);

        jLabel10.setText("Ingrese los datos del intrumento");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(24, 194, 155, 14);

        jLabel12.setText("ID:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(160, 240, 15, 14);

        jLabel4.setText("Dia:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(42, 62, 19, 14);

        Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiaActionPerformed(evt);
            }
        });
        jPanel2.add(Dia);
        Dia.setBounds(71, 59, 51, 20);

        jLabel5.setText("Mes:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(183, 62, 23, 14);

        jPanel2.add(Mes);
        Mes.setBounds(224, 59, 53, 20);

        jLabel8.setText("Año:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(331, 62, 23, 14);

        jPanel2.add(Annio);
        Annio.setBounds(372, 59, 61, 20);

        Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaActionPerformed(evt);
            }
        });
        jPanel2.add(Cedula);
        Cedula.setBounds(298, 144, 135, 30);

        jLabel9.setText("Cedula:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(243, 147, 37, 14);

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        jPanel2.add(ID);
        ID.setBounds(190, 230, 104, 30);

        Estudiante.setBackground(new java.awt.Color(255, 255, 255));
        Estudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Estudiante.setText("Estudiante");
        Estudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteActionPerformed(evt);
            }
        });
        jPanel2.add(Estudiante);
        Estudiante.setBounds(120, 140, 100, 30);

        Profesor.setBackground(new java.awt.Color(255, 255, 255));
        Profesor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Profesor.setText("Profesor");
        Profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfesorActionPerformed(evt);
            }
        });
        jPanel2.add(Profesor);
        Profesor.setBounds(20, 140, 100, 30);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 480, 350));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mini.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 90, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/primer-plano-partitura_23-2147781799.jpg"))); // NOI18N
        jLabel19.setText("jLabel9");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.setState(MenuPrincipal.ICONIFIED);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null,"Desea salir del sistema?","Exit",dialog);
        if (result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaActionPerformed

    private void DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiaActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // si coiciden el tipo y el intrumento y esta disponible se guardan los datos, mostrar mensaje guardados
        
        if(Estudiante.isSelected()==false && Profesor.isSelected() ==false) JOptionPane.showMessageDialog(null, "Debe escoger entre Profesor o Estudiante");
        else{
            Instrumentos ventana = new Instrumentos();
            control.prestamoInstrumento(ventana,this);
        }
        
//        ventana.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_GuardarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Instrumentos ventana = new Instrumentos();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VolverActionPerformed

    private void EstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteActionPerformed
        if(Estudiante.isSelected()) Profesor.setSelected(false);
        else Profesor.setSelected(true);
        
    }//GEN-LAST:event_EstudianteActionPerformed
    
    private void ProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfesorActionPerformed
        if(Profesor.isSelected()) Estudiante.setSelected(false);
        else Estudiante.setSelected(true);
    }//GEN-LAST:event_ProfesorActionPerformed

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
            java.util.logging.Logger.getLogger(InstrumentosPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstrumentosPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstrumentosPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstrumentosPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstrumentosPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Annio;
    private javax.swing.JTextField Cedula;
    private javax.swing.JComboBox<String> Dia;
    private javax.swing.JRadioButton Estudiante;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> Mes;
    private javax.swing.JRadioButton Profesor;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
