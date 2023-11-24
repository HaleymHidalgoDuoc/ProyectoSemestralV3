package Modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Haleym Hidalgo
 */
public class Arriendo {
    //Atributos
    private int idRegistro;
    private Date fechaInicio;
    private Date fechaTermino;
    private int precio;
    private String descripcion;
    private String idCliente;
    private String rutVendedor;
    private String patenteVehiculo;
    
    //Constructor
    public Arriendo(int idRegistro, Date fechaInicio, Date fechaTermino, int precio, String descripcion, String idCliente, String rutVendedor, String patenteVehiculo) {
        this.idRegistro = idRegistro;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.precio = precio;
        this.descripcion = descripcion;
        this.idCliente = idCliente;
        this.rutVendedor = rutVendedor;
        this.patenteVehiculo = patenteVehiculo;
    }

    public Arriendo() {
    }
    
        
    //Accesadores y Mutadores
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(String rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }
    
    //Customers
    @Override
    public String toString() {
        return "Arriendo{" + "idRegistro=" + idRegistro + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", precio=" + precio + ", descripcion=" + descripcion + ", idCliente=" + idCliente + ", rutVendedor=" + rutVendedor + ", patenteVehiculo=" + patenteVehiculo + '}';
    }
    
    //Metodos propios
    public boolean guardarArriendo(String idEmpleado, String idVehiculo, String idCliente, String descripcion, Date fecTer, int precio){
        //Obtengo todos los datos
        java.sql.Date fechaInicio = new java.sql.Date(new Date().getTime());
        java.sql.Date fechaTermino = new java.sql.Date(fecTer.getTime());
        
        try{
            //Crear Conexcion
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            String query;
            PreparedStatement stmt;

            // Arriendo
            query = "INSERT INTO arriendo (fecha_inicio, fecha_termino, precio, descripcion, id_cliente, rut_empleado, patente_vehiculo) VALUES (?,?,?,?,?,?,?)";
            stmt = cnx.prepareStatement(query);
            stmt.setDate(1, fechaInicio);
            stmt.setDate(2, fechaTermino);
            stmt.setInt(3, precio);
            stmt.setString(4, descripcion);
            stmt.setString(5, idCliente);
            stmt.setString(6, idEmpleado);
            stmt.setString(7, idVehiculo);
            stmt.executeUpdate();

            //Vehiculo
            query = "UPDATE vehiculo SET disponibilidad=? WHERE patente_vehiculo=?";
            stmt = cnx.prepareStatement(query);
            stmt.setBoolean(1, false);
            stmt.setString(2, idVehiculo);
            stmt.executeUpdate();

            //Cliente
            query = "UPDATE cliente SET estado=? WHERE id_cliente=?";
            stmt = cnx.prepareStatement(query);
            stmt.setBoolean(1, false);
            stmt.setString(2, idCliente);
            stmt.executeUpdate();

            // Cerrar recursos
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cliente" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean cambiarEstados(String idCliente, String idVehiculo) {
        try {
            // Crear Conexión
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            String query;
            PreparedStatement stmt;

            // Actualizar Cliente
            System.out.println(idCliente);
            query = "UPDATE cliente SET estado=? WHERE id_cliente=?";
            stmt = cnx.prepareStatement(query);
            stmt.setBoolean(1, true);
            stmt.setString(2, idCliente);
            stmt.executeUpdate();

            // Actualizar Vehiculo
            query = "UPDATE vehiculo SET disponibilidad=? WHERE patente_vehiculo=?";
            stmt = cnx.prepareStatement(query);
            stmt.setBoolean(1, true);
            stmt.setString(2, idVehiculo);
            stmt.executeUpdate();

            // Cerrar recursos
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar datos " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al actualizar datos " + e.getMessage());
            return false;
        }
        return true;
    }

}
