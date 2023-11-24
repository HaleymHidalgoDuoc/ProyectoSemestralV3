/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
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
public class CtrlEmpleado {
    //Metodos BD
    public Empleado buscarEmpleadoID(String identificacion) {
        Empleado cuenta = new Empleado();

        try {
            //Crear Conexcion
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            System.out.println("Conexion Exitosa");

            //Consultar
            String query = "SELECT * FROM empleado WHERE rut_empleado = " + "'" + identificacion + "';";
            PreparedStatement stmt = cnx.prepareStatement(query);

            //Permanencia de Datos
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cuenta.setRutEmpleado(rs.getString("rut_empleado"));
                cuenta.setTipoEmpleado(rs.getString("tipo_empleado"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setApellidoP(rs.getString("apellidop"));
                cuenta.setApellidoM(rs.getString("apellidom"));
                cuenta.setDireccion(rs.getString("direccion"));
                cuenta.setEmail(rs.getString("email"));
                cuenta.setTelefono(rs.getString("telefono"));
                cuenta.setContrasenia(rs.getString("contrasenia"));
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
    
    //Metodos
    public List<Empleado> buscarVendedores() {
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM empleado WHERE tipo_empleado='VENDEDOR'";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Obtenemos los datos
                Empleado empleado = new Empleado();
                empleado.setRutEmpleado(rs.getString("rut_empleado"));
                empleado.setTipoEmpleado(rs.getString("tipo_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoP(rs.getString("apellidop"));
                empleado.setApellidoM(rs.getString("apellidom"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setEmail(rs.getString("email"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setContrasenia(rs.getString("contrasenia"));
                //Guardamos el cliente en la Lista
                System.out.println(empleado.toString());
                listaEmpleados.add(empleado); 
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
        System.out.println(listaEmpleados);
        return listaEmpleados;
    }

    public boolean guardarVendedor(Empleado empleado){
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
        
        System.out.println("Conexion Exitosa"); // <--------- BORRAR

        //Preparar Query
        String query = "INSERT INTO empleado VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, empleado.getRutEmpleado());
        stmt.setString(2, "VENDEDOR");
        stmt.setString(3, empleado.getNombre());
        stmt.setString(4, empleado.getApellidoP());
        stmt.setString(5, empleado.getApellidoM());
        stmt.setString(6, empleado.getDireccion());
        stmt.setString(7, empleado.getEmail());
        stmt.setString(8, empleado.getTelefono());
        stmt.setString(9, empleado.getContrasenia());
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
    
    public boolean actualizarEmpleado(Empleado empleado){
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
        
        System.out.println("Conexion Exitosa"); // <--------- BORRAR

        //Preparar Query
        String query = "UPDATE empleado SET rut_empleado=?, tipo_empleado=?, nombre=?, apellidop=?, apellidom=?, direccion=?, email=?, telefono=?, contrasenia=? WHERE rut_empleado=?;";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, empleado.getRutEmpleado());
        stmt.setString(2, empleado.getTipoEmpleado());
        stmt.setString(3, empleado.getNombre());
        stmt.setString(4, empleado.getApellidoP());
        stmt.setString(5, empleado.getApellidoM());
        stmt.setString(6, empleado.getDireccion());
        stmt.setString(7, empleado.getEmail());
        stmt.setString(8, empleado.getTelefono());
        stmt.setString(9, empleado.getContrasenia());
        stmt.setString(10, empleado.getRutEmpleado());
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
    
    public boolean eliminarVendedor(Empleado empleado){
        
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
 
        //Preparar Query
        String query = "DELETE FROM empleado WHERE rut_empleado=?;";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, empleado.getRutEmpleado());
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
