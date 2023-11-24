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
public class CtrlReportes {
    //Metodos Propios
    public List<Cliente> buscarClientes(){
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
}
