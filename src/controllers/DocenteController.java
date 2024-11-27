package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.Docente;
import models.Persona;
import models.Sesion;

public class DocenteController {

    public void initialize() {
        Persona usuarioActual = Sesion.getInstancia().getUsuarioActual();

        if (usuarioActual != null) {
            System.out.println("Usuario en sesión: " + usuarioActual.getNombre());

            if (usuarioActual instanceof Docente) {
                // Configura la interfaz o realiza acciones específicas para Docente
                configurarVistaParaDocente((Docente) usuarioActual);
            } else {
                System.out.println("Error: El usuario en sesión no es un docente.");
                // Podrías redirigir a una vista de error o cerrar la sesión
            }
        } else {
            System.out.println("No hay usuario en sesión.");
            // Podrías redirigir al login o manejarlo según la lógica de tu aplicación
        }
    }

    private void configurarVistaParaDocente(Docente docente) {
        // Configura la interfaz para el docente
        // Por ejemplo, puedes mostrar el nombre del docente en un Label
        System.out.println("Bienvenido, " + docente.getNombre());
    }

    @FXML
    private void DisponibilidadAction(ActionEvent event) {
    }

    @FXML
    private void HorarioAction(ActionEvent event) {
    }

    @FXML
    private void ReporteAction(ActionEvent event) {
    }

    @FXML
    private void SalirAction(ActionEvent event) {
    }

    @FXML
    private void ElegirCursoAction(ActionEvent event) {
    }

    @FXML
    private void EditarCursoAction(ActionEvent event) {
    }

    @FXML
    private void BorrarCursoAction(ActionEvent event) {
    }

    @FXML
    private void AgregarDisponibilidadAction(ActionEvent event) {
    }

    @FXML
    private void GenerarHorarioAction(ActionEvent event) {
    }
}
