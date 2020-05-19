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
public class FrmVerProductosHigiene extends javax.swing.JFrame {

    ConsultasBD consulta = new ConsultasBD();
    ArrayList<ProductoHigiene> listaProductosHigiene = new ArrayList<>();
    int idProducto = -1;

    /**
     * Creates new form FrmVerProductosHigiene
     */
    public FrmVerProductosHigiene() {
        initComponents();
        listaProductosHigiene = consulta.consultarProductosHigiene();
        llebarTablaProdH();
    }

    public void llebarTablaProdH() {
        DefaultTableModel llenar
                = (DefaultTableModel) tablaProductosHigiene.getModel();
        Object[] fila = new Object[7];
        //limpiar tabla
        for (int i = 0; i < tablaProductosHigiene.getRowCount(); i++) {
            llenar.removeRow(i);
            i = i - 1;
        }
        listaProductosHigiene.stream().map((aux) -> {
            fila[0] = aux.getId_Producto();
            return aux;
        }).map((aux) -> {
            fila[1] = aux.getNombre();
            return aux;
        }).map((aux) -> {
            fila[2] = aux.getMarca();
            return aux;
        }).map((aux) -> {
            fila[3] = aux.getPresentacion();
            return aux;
        }).map((aux) -> {
            fila[4] = aux.getCaducidad();
            return aux;
        }).map((aux) -> {
            fila[5] = aux.getPrecio();
            return aux;
        }).map((aux) -> {
            fila[6] = aux.getStock();
            return aux;
        }).forEachOrdered((_item) -> {
            llenar.addRow(fila);
        });
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
        tablaProductosHigiene = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProductosHigiene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "MARCA", "PRESENTACION", "CADUCIDAD", "PRECIO", "STOCK"
            }
        ));
        tablaProductosHigiene.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosHigieneMouseClicked(evt);
            }
        });
        tablaProductosHigiene.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaProductosHigieneKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductosHigiene);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar)
                    .addComponent(btnVolver))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosHigieneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosHigieneMouseClicked
        // TODO add your handling code here:
        int fila = tablaProductosHigiene.getSelectedRow();
        idProducto = Integer.parseInt(String.valueOf(tablaProductosHigiene.getValueAt(fila, 0)));
    }//GEN-LAST:event_tablaProductosHigieneMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if (idProducto != -1) {
            ProductoHigiene p = consulta.buscarProductoHigienePorID(idProducto);
            int boton = JOptionPane.showConfirmDialog(this,
                    "¿Desea borrar este elemento: " + p.getNombre()
                    + "?", "Advertencia!!", JOptionPane.YES_NO_OPTION);
            if (boton == JOptionPane.YES_NO_OPTION) {
                consulta.borrarProductoHigiene(idProducto);
                idProducto = -1;
            }
            listaProductosHigiene = consulta.consultarProductosHigiene();
            llebarTablaProdH();
        } else {
            JOptionPane.showMessageDialog(this, "debe tener un registro activo");
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (idProducto != -1) {
            Globales.productoHigiene = consulta.buscarProductoHigienePorID(idProducto);
            FrmEditarProductoHigiene frm = new FrmEditarProductoHigiene();
            frm.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe tener un registro activo!!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Farmacia frm = new Farmacia();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tablaProductosHigieneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProductosHigieneKeyReleased
        // TODO add your handling code here:
        int fila = tablaProductosHigiene.getSelectedRow();
        idProducto = Integer.parseInt(String.valueOf(tablaProductosHigiene.getValueAt(fila, 0)));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // AQUI ABRIMOS LA VENTANA PARA VEMTAS 
            Globales.productoHigiene = consulta.buscarProductoHigienePorID(idProducto);
            FrmEditarProductoHigiene frm = new FrmEditarProductoHigiene();
            frm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tablaProductosHigieneKeyReleased

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
            java.util.logging.Logger.getLogger(FrmVerProductosHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVerProductosHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVerProductosHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVerProductosHigiene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVerProductosHigiene().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductosHigiene;
    // End of variables declaration//GEN-END:variables
}