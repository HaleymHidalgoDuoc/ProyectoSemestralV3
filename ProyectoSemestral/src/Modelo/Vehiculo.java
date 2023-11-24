package Modelo;

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
public class Vehiculo {
    //Atributos
    private String patente;
    private String numMotor;
    private String numChasis;
    private String marca;
    private String modelo;
    private int anio;
    private int valorHora;
    private boolean disponibilidad;
    private String tipoCombustible;
    private String tipoVehiculo;
    
    //Constructor
    public Vehiculo(String patente, String numMotor, String numChasis, String marca, String modelo, int anio, int valorHora, boolean disponibilidad, String tipoCombustible, String tipoVehiculo) {
        this.patente = patente;
        this.numMotor = numMotor;
        this.numChasis = numChasis;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.valorHora = valorHora;
        this.disponibilidad = disponibilidad;
        this.tipoCombustible = tipoCombustible;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehiculo() {
        
    }
    
    //Accesadores y Mutadores
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    //Metodos Validaciones
    public boolean validarPatente(String Patente) {
    String regex = "^\\d{4}[A-Z]{2}|[A-Z]{2}\\d{4}$";
    return Patente.matches(regex);   
    }
     
    public  boolean validarAnio(String anio) {
    String regex = "^19[0-9]{2}|2[0-9]{3}$";
    return anio.matches(regex);   
    }
    
    //Metodos BD
    public List<Vehiculo> buscarVehiculos() {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT * FROM vehiculo";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Obtenemos los datos
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setPatente(rs.getString("patente_vehiculo"));
                vehiculo.setNumMotor(rs.getString("num_motor"));
                vehiculo.setNumChasis(rs.getString("nr_chasis"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnio(rs.getInt("anio"));
                vehiculo.setValorHora(rs.getInt("valor_hora"));
                vehiculo.setDisponibilidad(rs.getBoolean("disponibilidad"));
                vehiculo.setTipoCombustible(rs.getString("tipo_combustible"));
                vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
                
                //Guardamos el cliente en la Lista
                listaVehiculos.add(vehiculo); 
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
        return listaVehiculos;
    }
    
    public Vehiculo buscarVehiculoID(String patente) {
        Vehiculo vehiculo = new Vehiculo();
        try {
            //Crear Conexcion
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            System.out.println("Conexion Exitosa");

            //Consultar
            String query = "SELECT * FROM vehiculo WHERE patente_vehiculo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, patente);

            //Permanencia de Datos
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                //Obtenemos los datos
                vehiculo.setPatente(rs.getString("patente_vehiculo"));
                vehiculo.setNumMotor(rs.getString("num_motor"));
                vehiculo.setNumChasis(rs.getString("nr_chasis"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnio(rs.getInt("anio"));
                vehiculo.setValorHora(rs.getInt("valor_hora"));
                vehiculo.setDisponibilidad(rs.getBoolean("disponibilidad"));
                vehiculo.setTipoCombustible(rs.getString("tipo_combustible"));
                vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
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
        return vehiculo;
    }
    
    public boolean actualizarVehiculo(Vehiculo vehiculo){
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
        
        System.out.println("Conexion Exitosa"); // <--------- BORRAR

        //Preparar Query
        String query = "UPDATE vehiculo SET patente_vehiculo=?, num_motor=?, nr_chasis=?, marca=?, modelo=?, anio=?, valor_hora=?, disponibilidad=?, tipo_combustible=?, tipo_vehiculo=? WHERE patente_vehiculo=?;";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, vehiculo.getPatente());
        stmt.setString(2, vehiculo.getNumMotor());
        stmt.setString(3, vehiculo.getNumChasis());
        stmt.setString(4, vehiculo.getMarca());
        stmt.setString(5, vehiculo.getModelo());
        stmt.setInt(6, vehiculo.getAnio());
        stmt.setInt(7, vehiculo.getValorHora());
        stmt.setBoolean(8, vehiculo.getDisponibilidad());
        stmt.setString(9, vehiculo.getTipoCombustible());
        stmt.setString(10, vehiculo.getTipoVehiculo());
        stmt.setString(11, vehiculo.getPatente());
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
    
    public boolean guardarVehiculo(Vehiculo vehiculo){
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
        
        System.out.println("Conexion Exitosa"); // <--------- BORRAR

        //Preparar Query
        String query = "INSERT INTO vehiculo VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, vehiculo.getPatente());
        stmt.setString(2, vehiculo.getNumMotor());
        stmt.setString(3, vehiculo.getNumChasis());
        stmt.setString(4, vehiculo.getMarca());
        stmt.setString(5, vehiculo.getModelo());
        stmt.setInt(6, vehiculo.getAnio());
        stmt.setInt(7, vehiculo.getValorHora());
        stmt.setBoolean(8, vehiculo.getDisponibilidad());
        stmt.setString(9, vehiculo.getTipoCombustible());
        stmt.setString(10, vehiculo.getTipoVehiculo());
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
    
    public boolean eliminarVehiculo(Vehiculo vehiculo){
        
        try{
        //Crear Conexcion
        Conexion conexion1 = new Conexion();
        Connection cnx = conexion1.obtenerConexion();
 
        //Preparar Query
        String query = "DELETE FROM vehiculo WHERE patente_vehiculo=?;";
        PreparedStatement stmt = cnx.prepareStatement(query);
        //Datos de la Query
        stmt.setString(1, vehiculo.getPatente());
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
