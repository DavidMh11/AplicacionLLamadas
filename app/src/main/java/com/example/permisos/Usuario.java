package com.example.permisos;

import androidx.annotation.NonNull;

import java.io.Serializable;
public class Usuario implements Serializable {
    private String Nombre;
    private String apellidoP;
    private String apellidoM;
    private String Correo;
    private String Contraseña;
    private String  Telefono;

    public Usuario(String nombre, String apellidoP, String apellidoM, String correo, String contraseña, String telefono) {
        Nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        Correo = correo;
        Contraseña = contraseña;
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}

