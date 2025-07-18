/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventana;

import Controlador.ControladorEDA;
import static Ventana.MoverExpediente.modeloCombo;
import static Ventana.MoverExpediente.modeloCombo2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import paquete.*;
import tda.*;

/**
 *
 * @author EDUARDO
 */
public class Menu extends javax.swing.JFrame {
    private Login v1;
    private ControladorEDA control;
    private JComboBox<String> combo;
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form Menu
     * 
     * 
     */
    public Menu() {
        initComponents();
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        this.control = ControladorEDA.getInstance();
        
        MostrarTabla();
        setLocationRelativeTo(null);
        
        Image iconoulima = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/ulima (1).png"));
        setIconImage(iconoulima);
        
        SwingUtilities.invokeLater(() -> { //Esto solo se aplica la ventana del menú principal
        
        Timer timer1 = new Timer(500000, e -> { //Cambiar de acuerdo a lo necesitado
            if (this.isVisible()) {
                JOptionPane.showMessageDialog(this, "¿Sigues ahí? Recuerda continuar con tus trámites.");
                }
            }
        );
        
        //Alerta de urgencia de tramites
        Timer timer2 = new Timer(10000, e -> { //Cambiar de acuerdo a lo necesitado
            if (this.isVisible()) {
                generarAlerta();
                }
            }
        );
        
        timer1.start();
        timer2.start();
        });
        

        
        
        //Diseño de la tabla
        JTableHeader encabezado = jTable1.getTableHeader();
        encabezado.setFont(new Font("Arial", Font.BOLD, 16));
        encabezado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);

        if (jTable1.getParent() instanceof JViewport) {
            Container scrollPane = jTable1.getParent().getParent();
            if (scrollPane instanceof JScrollPane) {
                ((JScrollPane) scrollPane).setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
       
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!isSelected) {
                c.setBackground(Color.WHITE); 
                c.setForeground(Color.BLACK); 
            }

            return c;
        }
    });
        encabezado.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel tabla = new JLabel(value.toString());
                tabla.setFont(new Font("Arial", Font.BOLD, 14));
                tabla.setOpaque(true);
                tabla.setBackground(new Color(253,154,0));
                tabla.setForeground(Color.WHITE);
                tabla.setHorizontalAlignment(CENTER);
                tabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                return tabla;
            }
        });
        

        jTextField2.setText(String.valueOf(control.getContadorId()-1));
        
        if(modeloCombo.getSize()==0){
            modeloCombo.addElement("-Selecciona-");
            modeloCombo.addElement("Inicio");
            modeloCombo.addElement("Comunicaciones");
            modeloCombo.addElement("Ingenieria");
            modeloCombo.addElement("Matricula");
            modeloCombo.addElement("Arquitectura");
            modeloCombo.addElement("Secretaria");
            modeloCombo.addElement("Bienestar");
        }
        if(modeloCombo2.getSize()==0){
            modeloCombo2.addElement("-Selecciona-");
            modeloCombo2.addElement("Inicio");
            modeloCombo2.addElement("Comunicaciones");
            modeloCombo2.addElement("Ingenieria");
            modeloCombo2.addElement("Matricula");
            modeloCombo2.addElement("Arquitectura");
            modeloCombo2.addElement("Secretaria");
            modeloCombo2.addElement("Bienestar");
        }
        
        Tramite tram1=control.agregarInicio(1, 12345678, "Kevin", 123123123, "20230714@aloe.ulima.edu.pe", "Matricula", false);
        Tramite tram2=control.agregarInicio(2, 45645632, "Jorge", 123123123, "20235047@aloe.ulima.edu.pe", "Cambio de carrera", false);
        Tramite tram3=control.agregarInicio(3, 98798776, "Eduardo", 123123123, "20232694@aloe.ulima.edu.pe", "Solicitud documentos", false);
        tram1.getExpediente().agregarDocumentoReferencia("photo.png");
        tram2.getExpediente().agregarDocumentoReferencia("documento.pdf");
        tram3.getExpediente().agregarDocumentoReferencia("registro de nacimiento.png");
    }
    
    void MostrarTabla(){
        modelo.addColumn("ID");
        modelo.addColumn("Prioridad");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("DNI");
        this.jTable1.setModel(modelo); 
    }
    
    public void setLogin(Login v1){
        this.v1 = v1;
    }
    public void setCombo(JComboBox<String> combo){
        this.combo = combo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(253, 143, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Crear Tramite");
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMaximumSize(new java.awt.Dimension(97, 17));
        jButton1.setMinimumSize(new java.awt.Dimension(97, 17));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 40));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Administrar Tramite");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setMaximumSize(new java.awt.Dimension(97, 17));
        jButton2.setMinimumSize(new java.awt.Dimension(97, 17));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, 40));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Lista Tramites");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, 40));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Crear Dependencia");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setMaximumSize(new java.awt.Dimension(97, 17));
        jButton5.setMinimumSize(new java.awt.Dimension(97, 17));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 40));

        jButton6.setText("Cerrar Sesión");
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 120, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo blanco ulima (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Finalizar Tramite");
        jButton7.setToolTipText("");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setMaximumSize(new java.awt.Dimension(97, 17));
        jButton7.setMinimumSize(new java.awt.Dimension(97, 17));
        jButton7.setPreferredSize(new java.awt.Dimension(136, 17));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 180, 40));

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Tramites Finalizados");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setMaximumSize(new java.awt.Dimension(97, 17));
        jButton8.setMinimumSize(new java.awt.Dimension(97, 17));
        jButton8.setPreferredSize(new java.awt.Dimension(136, 17));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 170, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        jPanel4.setBackground(new java.awt.Color(253, 154, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("+ NOTIFICACIONES DE TRÁMITES URGENTES PENDIENTES");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 560, 30));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Cantidad de todos los");
        jLabel4.setToolTipText("");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("trámites pendientes");
        jLabel5.setToolTipText("");
        jLabel5.setFocusable(false);

        jTextField2.setEditable(false);
        jTextField2.setText("jTextField2");
        jTextField2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField2.setFocusable(false);
        jTextField2.setRequestFocusEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 150, 130));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("MENÚ PRINCIPAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jButton4.setBackground(new java.awt.Color(253, 143, 0));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.setBorder(null);
        jButton4.setFocusPainted(false);
        jButton4.setRequestFocusEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 80, 30));

        jTable1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTable1.setEnabled(false);
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 560, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/campus_MG_6569.jpg-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 640, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Crear_Expediente ventana3 = new Crear_Expediente();
        ventana3.setMenu(this);
        this.setVisible(false);
        ventana3.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MoverExpediente ventana4 = new MoverExpediente();
        ventana4.setMenu(this);
        this.setVisible(false);
        ventana4.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ListadeTramites ventana5 = new ListadeTramites();
        ventana5.setMenu(this);
        this.setVisible(false);
        ventana5.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        this.v1.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        generarAlerta();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CrearDependencia ventana6 = new CrearDependencia();
        ventana6.setMenu(this);
        this.setVisible(false);
        ventana6.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FinalizarTramiteEspecifico ventana7 = new FinalizarTramiteEspecifico();
        ventana7.setMenu(this);
        this.setVisible(false);
        ventana7.setVisible(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        TramitesFinalizados ventana8 = new TramitesFinalizados();
        ventana8.setMenu(this);
        this.setVisible(false);
        ventana8.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    
    public void generarAlerta(){
        
        if(control.getContadorTramites()<0){
            jTextField2.setText("0");
        } else{
            jTextField2.setText(String.valueOf(control.getContadorTramites()));
        }

        int contador = 0;
        
        Cola<Tramite> aux = control.getListaTramites().getListaTramites().copiar();
        modelo.setRowCount(0);
             
        while(!aux.esVacia()){

            String [] Datos = new String[4];
            Tramite t = aux.desencolar();
            Calendar x = t.getHoraInicio();
            LocalTime inicio = x.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            LocalTime actual = LocalTime.now();

            long minutos = ChronoUnit.MINUTES.between(inicio,actual);
            long horas = minutos/60;

            int dia = t.getHoraInicio().get(Calendar.DAY_OF_MONTH);
            int mes = t.getHoraInicio().get(Calendar.MONTH);
            int year = t.getHoraInicio().get(Calendar.YEAR);
            int hora = t.getHoraInicio().get(Calendar.HOUR_OF_DAY);
            int minutos2 = t.getHoraInicio().get(Calendar.MINUTE);


            if(minutos >= 1){ //Cambiar dependiendo de la urgencia de tiempo
                    System.out.println("AGREGUÉ: " + t.getExpediente().getIdTramite() + "\t");
                    Datos[0] = String.valueOf(t.getExpediente().getIdTramite());
                    Datos[1] = String.valueOf(t.getExpediente().getPrioridad());
                    Datos[2] = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(year) + " " + String.format("%02d:%02d", hora, minutos2);
                    Datos[3] = String.valueOf(t.getExpediente().getInteresado().getDNI());
                    modelo.addRow(Datos);
                    contador++;
            }   
        }


        if(contador > 1){
            control.reproducirSonido2();
            JOptionPane.showMessageDialog(this, "Tiene trámites pendientes " +contador+" URGENTES!","",JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
