package Controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Haleym Hidalgo
 */
public class CtrlArriendo {
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
