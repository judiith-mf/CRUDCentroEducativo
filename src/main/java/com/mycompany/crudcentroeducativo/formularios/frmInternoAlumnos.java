/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.crudcentroeducativo.formularios;

import com.mycompany.crudcentroeducativo.Entidades.Alumno;
import com.mycompany.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JDialog;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author juudi
 */
public class frmInternoAlumnos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmIAlumnos
     */
    public frmInternoAlumnos() {
        initComponents();
        configTabla();
        cargaTabla();
       
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
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alumnos");

        jButton1.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel modelo=(DefaultTableModel) jtAlumnos.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            jtAlumnos.setRowSorter(trSorter);

            if(txtBuscar.getText().length()==0){
                trSorter.setRowFilter(null);
            }else{
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void configTabla(){
        String col[]={"ID","DNI","NOMBRE","APELLIDOS","FECHA DE NACIMIENTO"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        jtAlumnos.setModel(modelo);
        jtAlumnos.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
    }
    
     private void cargaTabla(){
        DefaultTableModel modelo=(DefaultTableModel) jtAlumnos.getModel();
        AlumnoDaoImp alumno=AlumnoDaoImp.getInstance();
        
        try {
            List <Alumno> lst=alumno.getAll();
         
            for (Alumno alum: lst) {
                Object[] datos={alum.getId(),alum.getDni(),alum.getNombre(),alum.getApellido1()};
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        
        
    }
    
    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        if(evt.getClickCount()==2){
            /*JDialog frame=new JDialog(this,"Detalle alumno",true);

            jpAlumnoDetalle panel =new jpAlumnoDetalle();
            int idSeleccion = Integer.parseInt(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0).toString()) ;
            panel.CargaDetalle(idSeleccion);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);*/
        }
    }//GEN-LAST:event_jtAlumnosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}