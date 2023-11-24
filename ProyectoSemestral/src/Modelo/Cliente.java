package Modelo;

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
public class Cliente {
    //Atributos
    private String idCliente;
    private String tipoCliente;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNacimiento;
    private String direccion;
    private String email;
    private String telefono;
    private boolean estado;
    
    //Constructor
    public Cliente(String idCliente, String tipoCliente, String nombre, String apellidoP, String apellidoM, Date fechaNacimiento, String direccion, String email, String telefono, boolean estado) {
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Cliente() {
    }
    
    //Accesadores y Mutadores
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Metodos Protpios

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", tipoCliente=" + tipoCliente + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + ", estado=" + estado + '}';
    }
    
    //Metodos Validaciones
    public boolean validarRut(String rut) {
        // Definir la expresión regular para validar el RUT
        String regex = "^\\d{8}-[\\dKk]$";

        // Verificar si el RUT coincide con la expresión regular
        return rut.matches(regex);
    }
    
    public boolean validarfechaNacimiento(String fechaNacimiento) {
    String regex = "^[1-2][0-9][0-9][0-9]/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])$";
    return fechaNacimiento.matches(regex);   
    }
    
    
    public boolean validarEmail(String Email) {
    String regex = ".*@.*";
    return Email.matches(regex);
    }
    
}
