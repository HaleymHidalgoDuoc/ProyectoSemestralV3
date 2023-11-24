package Modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

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
    
}
