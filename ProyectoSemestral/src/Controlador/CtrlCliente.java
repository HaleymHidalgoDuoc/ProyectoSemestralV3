
package Controlador;

import Modelo.Cliente;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Haleym Hidalgo
 */
public class CtrlCliente {
    //Metodos BD
    public List<Cliente> buscarClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM cliente";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Obtenemos los datos
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getString("id_cliente"));
                cliente.setTipoCliente(rs.getString("tipo_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoP(rs.getString("apellidop"));
                cliente.setApellidoM(rs.getString("apellidom"));
                cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));
                //Guardamos el cliente en la Lista
                System.out.println(cliente.toString());
                listaClientes.add(cliente); 
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
        System.out.println(listaClientes);
        return listaClientes;
    }
    
    public Cliente buscarClienteID(String identificacion) {
        Cliente cuenta = new Cliente();

        try {
            //Crear Conexcion
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            System.out.println("Conexion Exitosa");

            //Consultar
            String query = "SELECT * FROM cliente WHERE id_cliente = " + "'" + identificacion + "';";
            PreparedStatement stmt = cnx.prepareStatement(query);

            //Permanencia de Datos
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cuenta.setIdCliente(rs.getString("id_cliente"));
                cuenta.setTipoCliente(rs.getString("tipo_cliente"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setApellidoP(rs.getString("apellidop"));
                cuenta.setApellidoM(rs.getString("apellidom"));
                cuenta.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                cuenta.setDireccion(rs.getString("direccion"));
                cuenta.setEmail(rs.getString("email"));
                cuenta.setTelefono(rs.getString("telefono"));
                cuenta.setEstado(rs.getBoolean("estado")); 
            }

            //Cerrar la Conexion
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar empleado por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar empleado por id" + e.getMessage());
        }
        return cuenta;
    }
    
    public boolean guardarCliente(Cliente cliente){
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
        
        System.out.println("Conexion Exitosa"); // <--------- BORRAR

        // Convertir la fecha de nacimiento a java.sql.Date
        java.sql.Date fechaNacimiento = new java.sql.Date(cliente.getFechaNacimiento().getTime());
        //Preparar Query
        String query = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, cliente.getIdCliente());
        stmt.setString(2, cliente.getTipoCliente());
        stmt.setString(3, cliente.getNombre());
        stmt.setString(4, cliente.getApellidoP());
        stmt.setString(5, cliente.getApellidoM());
        stmt.setDate(6, fechaNacimiento);
        stmt.setString(7, cliente.getDireccion());
        stmt.setString(8, cliente.getEmail());
        stmt.setString(9, cliente.getTelefono());
        stmt.setBoolean(10, cliente.getEstado());
        stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cliente" + e.getMessage());
            return false;
        }
     return true;
    }
    
    public boolean actualizarCliente(Cliente cliente){
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
        
        System.out.println("Conexion Exitosa"); // <--------- BORRAR

        // Convertir la fecha de nacimiento a java.sql.Date
        java.sql.Date fechaNacimiento = new java.sql.Date(cliente.getFechaNacimiento().getTime());
        //Preparar Query
        String query = "UPDATE cliente SET id_cliente=?, tipo_cliente=?, nombre=?, apellidop=?, apellidom=?, fecha_nacimiento=?, direccion=?, email=?, telefono=?, estado=? WHERE id_cliente=?;";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, cliente.getIdCliente());
        stmt.setString(2, cliente.getTipoCliente());
        stmt.setString(3, cliente.getNombre());
        stmt.setString(4, cliente.getApellidoP());
        stmt.setString(5, cliente.getApellidoM());
        stmt.setDate(6, fechaNacimiento);
        stmt.setString(7, cliente.getDireccion());
        stmt.setString(8, cliente.getEmail());
        stmt.setString(9, cliente.getTelefono());
        stmt.setBoolean(10, cliente.getEstado());
        stmt.setString(11, cliente.getIdCliente());
        stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cliente" + e.getMessage());
            return false;
        }

        return true;
    }
    
    public boolean eliminarCliente(Cliente cliente){
        
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
 
        //Preparar Query
        String query = "DELETE FROM cliente WHERE id_cliente=?;";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, cliente.getIdCliente());
        stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cliente" + e.getMessage());
            return false;
        }

        return true; 
    }
    
}
