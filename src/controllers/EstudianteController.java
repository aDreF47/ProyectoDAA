package controllers;

import javafx.fxml.FXML;
import models.Estudiante;
import models.Persona;
import models.Sesion;

public class EstudianteController {

    @FXML
    public void initialize() {
        Persona usuarioActual = Sesion.getInstancia().getUsuarioActual();

        if (usuarioActual != null) {
            System.out.println("Usuario en sesión: " + usuarioActual.getNombre());

            if (usuarioActual instanceof Estudiante) {
                // Configura la interfaz o realiza acciones específicas para Estudiante
                configurarVistaParaEstudiante((Estudiante) usuarioActual);
            } else {
                System.out.println("Error: El usuario en sesión no es un estudiante.");
                // Podrías redirigir a una vista de error o cerrar la sesión
            }
        } else {
            System.out.println("No hay usuario en sesión.");
            // Podrías redirigir al login o manejarlo según la lógica de tu aplicación
        }
    }

    private void configurarVistaParaEstudiante(Estudiante estudiante) {
        // Configura la interfaz para el estudiante
        // Por ejemplo, puedes mostrar el nombre del estudiante en un Label
        System.out.println("Bienvenido, " + estudiante.getNombre());
    }
}
