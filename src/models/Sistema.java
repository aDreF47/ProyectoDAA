package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Sistema {
    private HashMap<String, Persona> personasMap = new HashMap<>();

    public Sistema() {
        cargarDatos(); // Automatically load data when Sistema is initialized
    }

    private void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/files/personas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String codigo = partes[0];
                String nombre = partes[1];
                String correo = partes[2];
                String contraseña = partes[3];

                Persona persona;
                if (correo.endsWith("@alumno.pe")) {
                    persona = new Estudiante(codigo, nombre, correo, contraseña);
                } else if (correo.endsWith("@docente.pe")) {
                    persona = new Docente(codigo, nombre, correo, contraseña);
                } else {
                    continue; // Ignore invalid records
                }

                personasMap.put(correo, persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Persona obtenerPersonaPorCorreo(String correo) {
        return personasMap.get(correo); // Retrieves the Persona object by email
    }

    public boolean verificarAcceso(String correo, String contraseña) {
        Persona persona = personasMap.get(correo);
        return persona != null && persona.getContraseña().equals(contraseña);
    }
}
