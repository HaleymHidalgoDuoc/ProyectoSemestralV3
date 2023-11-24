package Controlador;

import Modelo.Arriendo;
import Modelo.Empleado;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Arriendo> listarArriendosVehiculos(String patente) {
        List<Arriendo> listaArriendos = new ArrayList<Arriendo>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM arriendo WHERE patente_vehiculo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, patente);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Obtenemos los datos
                Arriendo arriendo = new Arriendo();
                arriendo.setIdRegistro(rs.getInt("id_registro"));
                arriendo.setFechaInicio(rs.getDate("fecha_inicio"));
                arriendo.setFechaTermino(rs.getDate("fecha_termino"));
                arriendo.setPrecio(rs.getInt("precio"));
                arriendo.setDescripcion(rs.getString("descripcion"));
                arriendo.setIdCliente(rs.getString("id_cliente"));
                arriendo.setRutVendedor(rs.getString("rut_empleado"));
                arriendo.setPatenteVehiculo(rs.getString("patente_vehiculo"));
                //Guardamos el cliente en la Lista
                System.out.println(arriendo.toString());
                listaArriendos.add(arriendo); 
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Cliente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Cliente: " + e.getMessage());
        }
        //Devolvemos la Lista con los Clientes 
        System.out.println(listaArriendos);
        return listaArriendos;
    }
}
