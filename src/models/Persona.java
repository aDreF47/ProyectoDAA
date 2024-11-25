/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nando
 */
public abstract class Persona {
    private String codigo;
    private String nombre;
    private String correo;
    private String contraseña;
    
    
    public Persona(String codigo, String nombre, String correo, String contraseña) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getContraseña() { return contraseña; }

}
