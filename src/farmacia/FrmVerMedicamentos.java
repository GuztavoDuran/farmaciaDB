/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class FrmVerMedicamentos extends javax.swing.JFrame {
    
    ConsultasBD consulta = new ConsultasBD();
    ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
    int idMedicamento = -1;

    /**
     * Creates new form FrmVerMedicamentos
     */
    public FrmVerMedicamentos() {
        initComponents();
        listaMedicamentos = consulta.consultarMedicamentos();
        llenarTablaMedicamentos();
    }
    
    public void llenarTablaMedicamentos(){
        DefaultTableModel llenar
                = (DefaultTableModel) tablaMedicamentos.getModel();
        Object[] fila = new Object[10];
        //limpiar tabla
        for (int i = 0; i < tablaMedicamentos.getRowCount(); i++) {
            llenar.removeRow(i);
            i = i - 1;
        }
        for (Medicamento aux : listaMedicamentos) {
            fila[0] = aux.getId_Medicamento();
            fila[1] = aux.getNombreComercial();
            fila[2] = aux.getNombreGenerico();
            fila[3] = aux.getPresentacion();
            fila[4] = aux.getFormaFarmaceutica();
            fila[5] = aux.getCondicionVenta();
            fila[6] = aux.getCaducidad();
            fila[7] = aux.getFabricante();
            fila[8] = aux.getStock();
            fila[9] = aux.getPrecio();
            llenar.addRow(fila);
        }
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
        tablaMedicamentos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Medicamentos");

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre Comercial", "Nombre Generico", "Presentación", "Forma Farmaceutica", "Condicion Venta", "Caducidad", "Fabricante", "Stock", "Precio"
            }
        ));
        tablaMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMedicamentosMouseClicked(evt);
            }
        });
        tablaMedicamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaMedicamentosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMedicamentos);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (idMedicamento != -1) {
            Globales.medicamentoG = consulta.buscarMedicamentoPorID(idMedicamento);
            FrmEditarMedicamento frm = new FrmEditarMedicamento();
            frm.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe tener un registro activo!!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if (idMedicamento != -1) {
            Medicamento p = consulta.buscarMedicamentoPorID(idMedicamento);
            int boton = JOptionPane.showConfirmDialog(this,
                    "¿Desea borrar este elemento: " + 
                        p.getNombreComercial() + " " + p.getNombreGenerico()
                        + "?", "Advertencia!!", JOptionPane.YES_NO_OPTION);
            if (boton == JOptionPane.YES_NO_OPTION) {
                consulta.borrarMedicamento(idMedicamento);
                idMedicamento = -1;
            }
            listaMedicamentos = consulta.consultarMedicamentos();
            llenarTablaMedicamentos();
        } else {
            JOptionPane.showMessageDialog(this, "debe tener un registro activo");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
       listaMedicamentos = consulta.consultarMedicamentos();
       llenarTablaMedicamentos();
       JOptionPane.showMessageDialog(null, "Se actualizaron los registros");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaMedicamentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaMedicamentosKeyReleased
        // TODO add your handling code here:
        int fila = tablaMedicamentos.getSelectedRow();
        idMedicamento = Integer.parseInt(String.valueOf(tablaMedicamentos.getValueAt(fila, 0)));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // AQUI ABRIMOS LA VENTANA PARA VEMTAS 
            Globales.medicamentoG = consulta.buscarMedicamentoPorID(idMedicamento);
            FrmEditarMedicamento frm = new FrmEditarMedicamento();
            frm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tablaMedicamentosKeyReleased

    private void tablaMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedicamentosMouseClicked
        // TODO add your handling code here:
        int fila = tablaMedicamentos.getSelectedRow();
        idMedicamento = Integer.parseInt(String.valueOf(tablaMedicamentos.getValueAt(fila, 0)));
    }//GEN-LAST:event_tablaMedicamentosMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Farmacia frmFarmacia = new Farmacia();
        frmFarmacia.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVerMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVerMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVerMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVerMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVerMedicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMedicamentos;
    // End of variables declaration//GEN-END:variables
}