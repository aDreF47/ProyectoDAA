package models;



import java.util.List;

public class Estudiante extends Persona{
    private List<Curso> cursosInscritos;

    public Estudiante(String codigo, String nombre, String correo, String contraseña) {
        super(codigo, nombre, correo, contraseña);
    }

}
