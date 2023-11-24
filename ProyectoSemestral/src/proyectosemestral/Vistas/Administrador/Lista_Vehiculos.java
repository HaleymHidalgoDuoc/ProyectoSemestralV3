package proyectosemestral.Vistas.Administrador;

//Vistas
import proyectosemestral.Vistas.administrador.Vehiculo.*;
import proyectosemestral.Vistas.administrador.Lista_Reporte;
import proyectosemestral.Vistas.Administrador.Vehiculo.Eliminar_Vehiculo;
        
//Modelo
import Modelo.*;
import Controlador.DibujarTabla;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import proyectosemestral.Vistas.Administrador.Vehiculo.Modificar_Vehiculo;
import proyectosemestral.Vistas.VLogin;


/**
 *
 * @author angel
 */
public class Lista_Vehiculos extends javax.swing.JFrame {
    
    //Atributos
    private Empleado empleado;

    public void setEmpleado(Empleado emp) {
        this.empleado = emp;
        String nombre = empleado.getNombre() + " " + empleado.getApellidoP();
        lbl_nombe_de.setText(nombre);
        lbl_tipoEmpleado.setText(empleado.getTipoEmpleado());
        actualizarTabla();
    }
    
    //Customer
    private void actualizarTabla(){
        //Declaraciones Necesarias
        DefaultTableModel modelo = (DefaultTableModel) tblVehiculos.getModel();
        String patente;
        String marca;
        String tipoVehiculo;
        String disponible;
        JButton btnVer, btnEditar, btnEliminar;
        
        Vehiculo con = new Vehiculo();
        modelo.setRowCount(0);
        
        String id = txt_buscar.getText();
        if(id.isEmpty() || id.equals(" ") || id.equals("Patente")){
            //Obtengo la Lista de Clientes
            List<Vehiculo> listaVehiculos = con.buscarVehiculos();
            
            for (Vehiculo vehiculoTem : listaVehiculos) {
                patente = vehiculoTem.getPatente();
                marca = vehiculoTem.getMarca();
                tipoVehiculo = vehiculoTem.getTipoVehiculo();
                if(vehiculoTem.getDisponibilidad()){
                    disponible = "Si";
                } else{
                    disponible = "No";
                }
                //Botones de Accion RUD
                btnVer = new JButton("R");
                btnVer.setName("ver");
                btnEditar = new JButton("U");
                btnEditar.setName("editar");
                btnEliminar = new JButton("D");
                btnEliminar.setName("eliminar");
                //Actualiza el Modelo
                modelo.addRow(new Object[] {patente, marca, tipoVehiculo, disponible, btnVer, btnEditar, btnEliminar});
            }
            //Actializo la Tabla
            tblVehiculos.setDefaultRenderer(Object.class, new DibujarTabla());
            tblVehiculos.setModel(modelo);
            
            String nr_resultados = "Nº " + listaVehiculos.size();
            lbl_num.setText(nr_resultados);
        }
    }
    

    /**
     * Creates new form Vendedor
     */
    public Lista_Vehiculos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane_parte_arriba = new javax.swing.JPanel();
        icon_auto = new javax.swing.JLabel();
        lbl_autto = new javax.swing.JLabel();
        lbl_listadevendedores = new javax.swing.JLabel();
        lbl_nombe_de = new javax.swing.JLabel();
        lbl_tipoEmpleado = new javax.swing.JLabel();
        lbl_icon_persona = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        pane_fondo_buscar = new javax.swing.JPanel();
        btn_icon_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        pane_fondo_resultados = new javax.swing.JPanel();
        lbl_resultados = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        pane_central = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        pane_lado_izquierdo = new javax.swing.JPanel();
        btn_Vendedores = new javax.swing.JButton();
        btn_Vehiculo = new javax.swing.JButton();
        btn_Reporte = new javax.swing.JButton();
        btn_cerrar_session = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pane_parte_arriba.setBackground(new java.awt.Color(204, 204, 204));

        icon_auto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/car-removebg-preview.png"))); // NOI18N

        lbl_autto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_autto.setText("AUTTO");

        lbl_listadevendedores.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_listadevendedores.setText("LISTA DE VEHICULOS");

        lbl_nombe_de.setText("Nombre Apellido");

        lbl_tipoEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_tipoEmpleado.setText("Tipo Empleado");

        lbl_icon_persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_person3.png"))); // NOI18N

        javax.swing.GroupLayout pane_parte_arribaLayout = new javax.swing.GroupLayout(pane_parte_arriba);
        pane_parte_arriba.setLayout(pane_parte_arribaLayout);
        pane_parte_arribaLayout.setHorizontalGroup(
            pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                .addComponent(icon_auto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_autto)
                .addGap(320, 320, 320)
                .addComponent(lbl_listadevendedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_nombe_de, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_tipoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(lbl_icon_persona)
                .addGap(41, 41, 41))
        );
        pane_parte_arribaLayout.setVerticalGroup(
            pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_parte_arribaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_parte_arribaLayout.createSequentialGroup()
                            .addComponent(icon_auto)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_parte_arribaLayout.createSequentialGroup()
                            .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_autto)
                                .addComponent(lbl_listadevendedores))
                            .addGap(28, 28, 28)))
                    .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                        .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lbl_nombe_de)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tipoEmpleado))
                            .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lbl_icon_persona)))
                        .addGap(43, 43, 43))))
        );

        btn_nuevo.setBackground(new java.awt.Color(102, 102, 102));
        btn_nuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevo.setText("+ NUEVO");
        btn_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevoMouseClicked(evt);
            }
        });
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        pane_fondo_buscar.setBackground(new java.awt.Color(102, 102, 102));

        btn_icon_buscar.setBackground(new java.awt.Color(102, 102, 102));
        btn_icon_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_icon_buscar.setText("🔎");
        btn_icon_buscar.setBorder(null);
        btn_icon_buscar.setPreferredSize(new java.awt.Dimension(25, 25));
        btn_icon_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_icon_buscarActionPerformed(evt);
            }
        });

        txt_buscar.setForeground(new java.awt.Color(204, 204, 204));
        txt_buscar.setText("Patente");
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane_fondo_buscarLayout = new javax.swing.GroupLayout(pane_fondo_buscar);
        pane_fondo_buscar.setLayout(pane_fondo_buscarLayout);
        pane_fondo_buscarLayout.setHorizontalGroup(
            pane_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_fondo_buscarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_icon_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pane_fondo_buscarLayout.setVerticalGroup(
            pane_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_fondo_buscarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pane_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_icon_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar))
                .addContainerGap())
        );

        pane_fondo_resultados.setBackground(new java.awt.Color(153, 153, 153));

        lbl_resultados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_resultados.setText("Resulados:");

        lbl_num.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_num.setForeground(new java.awt.Color(255, 255, 255));
        lbl_num.setText("N° 0");

        javax.swing.GroupLayout pane_fondo_resultadosLayout = new javax.swing.GroupLayout(pane_fondo_resultados);
        pane_fondo_resultados.setLayout(pane_fondo_resultadosLayout);
        pane_fondo_resultadosLayout.setHorizontalGroup(
            pane_fondo_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_fondo_resultadosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_resultados)
                .addGap(10, 10, 10)
                .addComponent(lbl_num, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pane_fondo_resultadosLayout.setVerticalGroup(
            pane_fondo_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_fondo_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbl_resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_num, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patente", "Marca", "Tipo de Vehiculo", "Disponible", "Ver", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVehiculos);
        if (tblVehiculos.getColumnModel().getColumnCount() > 0) {
            tblVehiculos.getColumnModel().getColumn(0).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(1).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(2).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(3).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(4).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblVehiculos.getColumnModel().getColumn(5).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(5).setPreferredWidth(20);
            tblVehiculos.getColumnModel().getColumn(6).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        javax.swing.GroupLayout pane_centralLayout = new javax.swing.GroupLayout(pane_central);
        pane_central.setLayout(pane_centralLayout);
        pane_centralLayout.setHorizontalGroup(
            pane_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_centralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pane_centralLayout.setVerticalGroup(
            pane_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_centralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pane_lado_izquierdo.setBackground(new java.awt.Color(102, 102, 102));

        btn_Vendedores.setBackground(new java.awt.Color(102, 102, 102));
        btn_Vendedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Vendedores.setText("Vendedores");
        btn_Vendedores.setBorder(null);
        btn_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VendedoresActionPerformed(evt);
            }
        });

        btn_Vehiculo.setBackground(new java.awt.Color(102, 102, 102));
        btn_Vehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Vehiculo.setText("Vehiculo");
        btn_Vehiculo.setBorder(null);
        btn_Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VehiculoActionPerformed(evt);
            }
        });

        btn_Reporte.setBackground(new java.awt.Color(102, 102, 102));
        btn_Reporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Reporte.setText("Reporte");
        btn_Reporte.setBorder(null);
        btn_Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReporteActionPerformed(evt);
            }
        });

        btn_cerrar_session.setBackground(new java.awt.Color(204, 204, 204));
        btn_cerrar_session.setText("CERRAR SESION");
        btn_cerrar_session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar_sessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane_lado_izquierdoLayout = new javax.swing.GroupLayout(pane_lado_izquierdo);
        pane_lado_izquierdo.setLayout(pane_lado_izquierdoLayout);
        pane_lado_izquierdoLayout.setHorizontalGroup(
            pane_lado_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_lado_izquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_lado_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Vendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Vehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btn_Reporte, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btn_cerrar_session, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        pane_lado_izquierdoLayout.setVerticalGroup(
            pane_lado_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_lado_izquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btn_Vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btn_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btn_cerrar_session, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane_parte_arriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane_lado_izquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)
                        .addComponent(pane_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(pane_fondo_resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pane_central, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane_parte_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pane_fondo_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pane_fondo_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(pane_central, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pane_lado_izquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_nuevoMouseClicked

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
        new Nuevo_Vehiculo().setVisible(true);
        
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_icon_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_icon_buscarActionPerformed
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_btn_icon_buscarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_VendedoresActionPerformed

    private void btn_VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VehiculoActionPerformed
        // TODO add your handling code here:
        new Lista_Vehiculos().setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_VehiculoActionPerformed

    private void btn_ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReporteActionPerformed
        // TODO add your handling code here:
        Lista_Reporte venReporte = new Lista_Reporte();
        venReporte.setEmpleado(this.empleado);
        this.dispose();
    }//GEN-LAST:event_btn_ReporteActionPerformed

    private void btn_cerrar_sessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_sessionActionPerformed
        // TODO add your handling code here:
        VLogin Ventana = new VLogin();
        Ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cerrar_sessionActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
        //Botones
        int columna = tblVehiculos.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY()/tblVehiculos.getRowHeight();

        if(fila < tblVehiculos.getRowCount() && fila >= 0 &&
            columna < tblVehiculos.getColumnCount() && columna >= 0){

            Object value = tblVehiculos.getValueAt(fila, columna);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                //Eventos
                if(boton.getName().equals("ver")){

                    String identificacion = (String) tblVehiculos.getValueAt(fila, 0);

                    Vehiculo cnx = new Vehiculo(); //Creo una "Conexion"
                    Vehiculo vehiculo = cnx.buscarVehiculoID(identificacion); //Creo una Instancia de objeto con los datos de la busqueda (devuelve Null si no encuntra)

                    //Instancia una Ventana de Informacion
                    Ver_Vehiculo ver = new Ver_Vehiculo();
                    ver.setVehiculo(vehiculo);
                    ver.setVisible(true);

                } else if(boton.getName().equals("editar")){

                    String identificacion = (String) tblVehiculos.getValueAt(fila, 0);

                    Vehiculo cnx = new Vehiculo(); //Creo una "Conexion"
                    Vehiculo vehiculo = cnx.buscarVehiculoID(identificacion); //Creo una Instancia de objeto con los datos de la busqueda (devuelve Null si no encuntra)

                    //Instancia una Ventana de Edicion
                    Modificar_Vehiculo venEditar = new Modificar_Vehiculo();
                    venEditar.setVehiculo(vehiculo);
                    venEditar.setVisible(true);

                } else if(boton.getName().equals("eliminar")){

                    String identificacion = (String) tblVehiculos.getValueAt(fila, 0);

                    Vehiculo cnx = new Vehiculo(); //Creo una "Conexion"
                    Vehiculo vehiculo = cnx.buscarVehiculoID(identificacion); //Creo una Instancia de objeto con los datos de la busqueda (devuelve Null si no encuntra)

                    //Instancia de una Ventana de Eliminacion
                    Eliminar_Vehiculo venEliminar = new Eliminar_Vehiculo();
                    venEliminar.setVehiculo(vehiculo);
                    venEliminar.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_tblVehiculosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Reporte;
    private javax.swing.JButton btn_Vehiculo;
    private javax.swing.JButton btn_Vendedores;
    private javax.swing.JButton btn_cerrar_session;
    private javax.swing.JButton btn_icon_buscar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JLabel icon_auto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_autto;
    private javax.swing.JLabel lbl_icon_persona;
    private javax.swing.JLabel lbl_listadevendedores;
    private javax.swing.JLabel lbl_nombe_de;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JLabel lbl_resultados;
    private javax.swing.JLabel lbl_tipoEmpleado;
    private javax.swing.JPanel pane_central;
    private javax.swing.JPanel pane_fondo_buscar;
    private javax.swing.JPanel pane_fondo_resultados;
    private javax.swing.JPanel pane_lado_izquierdo;
    private javax.swing.JPanel pane_parte_arriba;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
