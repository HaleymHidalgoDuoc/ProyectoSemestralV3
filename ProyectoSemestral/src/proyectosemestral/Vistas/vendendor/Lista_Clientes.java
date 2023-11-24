package proyectosemestral.Vistas.vendendor;

//import Controlador.Registro;
import Controlador.CtrlCliente;
import Modelo.Cliente;
import Modelo.Empleado;
import Controlador.DibujarTabla;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import proyectosemestral.Vistas.VLogin;
import proyectosemestral.Vistas.vendendor.Lista_Cliente.*;



/**
 *
 * @author angel
 */
public class Lista_Clientes extends javax.swing.JFrame {
    
    //Atributos
    private Empleado empleado;

    public void setEmpleado(Empleado emp) {
        this.empleado = emp;
        String nombre = empleado.getNombre() + " " + empleado.getApellidoP();
        //Setea Datos de la Vista
        lbl_nombe_de.setText(nombre);
        lbl_vendedor.setText(empleado.getTipoEmpleado());
        actualizarTabla();
    }
    
    //Customer
    private void actualizarTabla(){
        //Declaraciones Necesarias
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        String identificacion;
        String nombre;
        String apellido;
        String estado;
        JButton btnVer, btnEditar, btnEliminar;
        
        CtrlCliente con = new CtrlCliente();
        modelo.setRowCount(0);
        
        String id = txt_buscar.getText();
        if(id.isEmpty() || id.equals(" ") || id.equals("Identificación")){
            //Obtengo la Lista de Clientes
            List<Cliente> listaClientes = con.buscarClientes();
            
            for (Cliente clienteTem : listaClientes) {
                identificacion = clienteTem.getIdCliente();
                nombre = clienteTem.getNombre();
                apellido = clienteTem.getApellidoP() + " " + clienteTem.getApellidoM();
                if(clienteTem.getEstado()){
                    estado = "Sin Deuda";
                } else {
                    estado = "Con Deuda";
                }
                //Botones de Accion RUD
                btnVer = new JButton("R");
                btnVer.setName("ver");
                btnEditar = new JButton("U");
                btnEditar.setName("editar");
                btnEliminar = new JButton("D");
                btnEliminar.setName("eliminar");
                //Actualiza el Modelo
                modelo.addRow(new Object[] {identificacion, nombre, apellido, estado, btnVer, btnEditar, btnEliminar});
            }
            //Actializo la Tabla
            tblClientes.setDefaultRenderer(Object.class, new DibujarTabla());
            tblClientes.setModel(modelo);
            
            String nr_resultados = "Nº " + listaClientes.size();
            lbl_num.setText(nr_resultados);
        }
    }
    


    /**
     * Creates new form Vendedor
     */
    public Lista_Clientes() {
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
        lbl_listadeclientes = new javax.swing.JLabel();
        lbl_nombe_de = new javax.swing.JLabel();
        lbl_vendedor = new javax.swing.JLabel();
        lbl_icon_persona = new javax.swing.JLabel();
        pane_lado_izquierdo = new javax.swing.JPanel();
        btn_clientes = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        btn_devolucion = new javax.swing.JButton();
        btn_cerrar_session = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        pane_fondo_buscar = new javax.swing.JPanel();
        btn_icon_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        pane_fondo_resultados = new javax.swing.JPanel();
        lbl_resultados = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        pane_central = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pane_parte_arriba.setBackground(new java.awt.Color(204, 204, 204));

        icon_auto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/car-removebg-preview.png"))); // NOI18N

        lbl_autto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_autto.setText("AUTTO");

        lbl_listadeclientes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_listadeclientes.setText("LISTA DE CLIENTES");

        lbl_nombe_de.setText("Nombre Apellido");

        lbl_vendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vendedor.setText("TipoTrabajador");

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
                .addComponent(lbl_listadeclientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_nombe_de, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(lbl_listadeclientes))
                            .addGap(28, 28, 28)))
                    .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                        .addGroup(pane_parte_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lbl_nombe_de)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_vendedor))
                            .addGroup(pane_parte_arribaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lbl_icon_persona)))
                        .addGap(43, 43, 43))))
        );

        pane_lado_izquierdo.setBackground(new java.awt.Color(102, 102, 102));

        btn_clientes.setBackground(new java.awt.Color(102, 102, 102));
        btn_clientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_clientes.setText("Clientes");
        btn_clientes.setBorder(null);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_registrar.setBackground(new java.awt.Color(102, 102, 102));
        btn_registrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.setBorder(null);
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        btn_devolucion.setBackground(new java.awt.Color(102, 102, 102));
        btn_devolucion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_devolucion.setText("Devolución");
        btn_devolucion.setBorder(null);
        btn_devolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_devolucionActionPerformed(evt);
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
                .addGap(5, 5, 5)
                .addGroup(pane_lado_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_devolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_lado_izquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cerrar_session, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        pane_lado_izquierdoLayout.setVerticalGroup(
            pane_lado_izquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_lado_izquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cerrar_session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        txt_buscar.setText("Identificación");
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

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Identificación", "Nombre", "Apellido", "Estado", "Ver", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setResizable(false);
            tblClientes.getColumnModel().getColumn(1).setResizable(false);
            tblClientes.getColumnModel().getColumn(2).setResizable(false);
            tblClientes.getColumnModel().getColumn(3).setResizable(false);
            tblClientes.getColumnModel().getColumn(4).setResizable(false);
            tblClientes.getColumnModel().getColumn(4).setPreferredWidth(10);
            tblClientes.getColumnModel().getColumn(5).setResizable(false);
            tblClientes.getColumnModel().getColumn(5).setPreferredWidth(10);
            tblClientes.getColumnModel().getColumn(6).setResizable(false);
            tblClientes.getColumnModel().getColumn(6).setPreferredWidth(10);
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
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane_parte_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pane_fondo_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pane_fondo_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(pane_central, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addComponent(pane_lado_izquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        //
        Registrar_Arriendo VenArriendo = new Registrar_Arriendo();
        
        VenArriendo.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_registrarActionPerformed

    private void btn_devolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_devolucionActionPerformed
        // TODO add your handling code here:
        new Devolucion_vehiculo().setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_devolucionActionPerformed

    private void btn_cerrar_sessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_sessionActionPerformed
        // TODO add your handling code here:
        VLogin Ventana = new VLogin();

        Ventana.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btn_cerrar_sessionActionPerformed

    private void btn_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_nuevoMouseClicked

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
        new Nuevo_Cliente().setVisible(true);
        
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_icon_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_icon_buscarActionPerformed
        //Actualizar la Tabla
        actualizarTabla();
    }//GEN-LAST:event_btn_icon_buscarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        //Botones
         int columna = tblClientes.getColumnModel().getColumnIndexAtX(evt.getX());
         int fila = evt.getY()/tblClientes.getRowHeight();
         
         if(fila < tblClientes.getRowCount() && fila >= 0 &&
            columna < tblClientes.getColumnCount() && columna >= 0){
             
             Object value = tblClientes.getValueAt(fila, columna);
             if(value instanceof JButton){
                 ((JButton)value).doClick();
                 JButton boton = (JButton) value;
                 
                 //Eventos
                 if(boton.getName().equals("ver")){
                     
                    String identificacion = (String) tblClientes.getValueAt(fila, 0);

                    CtrlCliente cnx = new CtrlCliente(); //Creo una "Conexion"
                    Cliente cliente = cnx.buscarClienteID(identificacion); //Creo una Instancia de objeto con los datos de la busqueda (devuelve Null si no encuntra)

                    //Instancia una Ventana de Informacion
                    Ver_Cliente ver = new Ver_Cliente();
                    ver.setCliente(cliente);
                    ver.setVisible(true);
                     
                 } else if(boton.getName().equals("editar")){
                    
                    String identificacion = (String) tblClientes.getValueAt(fila, 0);

                    CtrlCliente cnx = new CtrlCliente(); //Creo una "Conexion"
                    Cliente cliente = cnx.buscarClienteID(identificacion); //Creo una Instancia de objeto con los datos de la busqueda (devuelve Null si no encuntra)

                    //Instancia una Ventana de Edicion
                    Editar_Cliente editar = new Editar_Cliente();
                    editar.setCliente(cliente);
                    editar.setVisible(true);
                      
                 } else if(boton.getName().equals("eliminar")){
                     
                    String identificacion = (String) tblClientes.getValueAt(fila, 0);
                    
                    CtrlCliente cnx = new CtrlCliente(); //Creo una "Conexion"
                    Cliente cliente = cnx.buscarClienteID(identificacion); //Creo una Instancia de objeto con los datos de la busqueda (devuelve Null si no encuntra)
                    
                    //Instancia de una Ventana de Eliminacion
                    Eliminar_Cliente eliminar = new Eliminar_Cliente();
                    eliminar.setCliente(cliente);
                    eliminar.setVisible(true);
                 }   
             }
         }
    }//GEN-LAST:event_tblClientesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar_session;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_devolucion;
    private javax.swing.JButton btn_icon_buscar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel icon_auto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_autto;
    private javax.swing.JLabel lbl_icon_persona;
    private javax.swing.JLabel lbl_listadeclientes;
    private javax.swing.JLabel lbl_nombe_de;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JLabel lbl_resultados;
    private javax.swing.JLabel lbl_vendedor;
    private javax.swing.JPanel pane_central;
    private javax.swing.JPanel pane_fondo_buscar;
    private javax.swing.JPanel pane_fondo_resultados;
    private javax.swing.JPanel pane_lado_izquierdo;
    private javax.swing.JPanel pane_parte_arriba;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
