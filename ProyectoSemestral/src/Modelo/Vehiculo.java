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
    
}
