package controllers;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.Docente;
import models.Persona;
import models.Sesion;

public class DocenteController {

    private List<String> horariosGenerados; // Lista para almacenar los horarios generados
    private int indiceHorarioActual = 0; // Índice del horario que se está mostrando actualmente
    @FXML
    private VBox horarioGeneradoContainer;
    @FXML
    private Text mensajeNoMasPropuestas;

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

    // Este método se ejecuta cuando el docente genera el primer horario
    @FXML
    private void GenerarHorarioAction() {
        // Generar el primer horario y mostrarlo en el segundo tab
        horariosGenerados = generarHorarios(); // Genera los horarios posibles (algoritmos voraces, etc.)
        if (horariosGenerados.isEmpty()) {
            mensajeNoMasPropuestas.setVisible(true);
        } else {
            mostrarHorario(horariosGenerados.get(indiceHorarioActual));
        }
    }
    
    // Método para generar nuevos horarios (algoritmos de optimización)
    private List<String> generarHorarios() {
        // Lógica para generar los horarios utilizando algoritmos voraces, etc.
        // Esto es solo un ejemplo; reemplaza con tu lógica de generación de horarios.
        return List.of(
            "Lunes 8:00 - 10:00, Martes 10:00 - 12:00",
            "Lunes 9:00 - 11:00, Miércoles 12:00 - 2:00"
        );
    }
    
    // Mostrar el horario en el contenedor
    private void mostrarHorario(String horario) {
        horarioGeneradoContainer.getChildren().clear();
        Text horarioText = new Text(horario); // Mostrar el horario generado
        horarioGeneradoContainer.getChildren().add(horarioText);
    }

    // Este método se ejecuta cuando el docente hace clic en "Generar nuevo horario"
    @FXML
    private void GenerarNuevoHorarioAction() {
        if (indiceHorarioActual + 1 < horariosGenerados.size()) {
            indiceHorarioActual++;
            mostrarHorario(horariosGenerados.get(indiceHorarioActual));
            mensajeNoMasPropuestas.setVisible(false);
        } else {
            mensajeNoMasPropuestas.setVisible(true);
        }
    }

    // Este método se ejecuta cuando el docente selecciona un horario
    @FXML
    private void SeleccionarHorarioAction() {
        // Lógica para guardar el horario seleccionado (puedes almacenar los datos en una base de datos, archivo, etc.)
        String horarioSeleccionado = horariosGenerados.get(indiceHorarioActual);
        System.out.println("Horario seleccionado: " + horarioSeleccionado);
        
        // Aquí podrías guardar el horario en una base de datos o realizar otra acción
    }
}
