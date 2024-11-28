package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Estudiante;
import models.Persona;
import models.Sesion;

public class EstudianteController {

    @FXML
    private Label idnombre;
    @FXML
    private TabPane PaneDocente;
    @FXML
    private Tab tabDisponibilidad;
    @FXML
    private TableView<?> tableCursoDisponible;
    @FXML
    private TableColumn<?, ?> colCursoDisponible;
    @FXML
    private TableColumn<?, ?> colHoraDisponible;
    @FXML
    private TableView<?> tableCursoElegido;
    @FXML
    private TableColumn<?, ?> colCursoElegido;
    @FXML
    private TableColumn<?, ?> colHoraElegido;
    @FXML
    private Tab tabHorarioGenerado;
    @FXML
    private VBox horarioGeneradoContainer;
    @FXML
    private Tab tabReporte;
    @FXML
    private TableView<?> tablaReporte;
    @FXML
    private TableColumn<?, ?> cicloRepDocente;
    @FXML
    private TableColumn<?, ?> seccionRepDocente;
    @FXML
    private TableColumn<?, ?> cursoRepDocente;
    @FXML
    private TableColumn<?, ?> horasRepDocente;
    @FXML
    private TableColumn<?, ?> deRepDocente;
    @FXML
    private TableColumn<?, ?> hastaRepDocente;
    @FXML
    private TableColumn<?, ?> diaRepDocente;
    @FXML
    private Button btnDescargarReporte;
    @FXML
    private Text mensajeNoMasPropuestas;
    @FXML
    private Label estudiantecodigo;
    @FXML
    private Label estudiantecorreo;

    public void initialize() {
        Persona usuarioActual = Sesion.getInstancia().getUsuarioActual();

        if (usuarioActual != null) {
            System.out.println("Usuario en sesión: " + usuarioActual.getNombre());

            if (usuarioActual instanceof Estudiante) {
                // Configura la interfaz o realiza acciones específicas para Estudiante
                configurarVistaParaEstudiante((Estudiante) usuarioActual);
                idnombre.setText(usuarioActual.getNombre());
                estudiantecodigo.setText(usuarioActual.getCodigo());
                estudiantecorreo.setText(usuarioActual.getCorreo());
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

    @FXML
    private void DisponibilidadAction(ActionEvent event) {
        PaneDocente.getSelectionModel().select(tabDisponibilidad);
    }

    @FXML
    private void HorarioAction(ActionEvent event) {
        PaneDocente.getSelectionModel().select(tabHorarioGenerado);
    }

    @FXML
    private void ReporteAction(ActionEvent event) {
        PaneDocente.getSelectionModel().select(tabReporte);
    }

    @FXML
    private void SalirAction(ActionEvent event) throws IOException {
        /*limpiar todo*/
        Parent regresarLogin = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
        Scene registrarScene = new Scene(regresarLogin);
        registrarScene.getStylesheets().add(getClass().getResource("/styles/styleLogin.css").toExternalForm());
        // Obtener el escenario actual y cambiar la escena
        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setScene(registrarScene);
        window.show();
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

    @FXML
    private void GenerarNuevoHorarioAction(ActionEvent event) {
    }

    @FXML
    private void SeleccionarHorarioAction(ActionEvent event) {
    }

    @FXML
    private void generarReporte(ActionEvent event) {
    }
}
