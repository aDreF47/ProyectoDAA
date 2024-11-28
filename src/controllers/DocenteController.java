package controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.*;

public class DocenteController {

    private DBCursos dbCurso;
    private List<String> horariosGenerados; // Lista para almacenar los horarios generados
    private int indiceHorarioActual = 0; // Índice del horario que se está mostrando actualmente
    @FXML
    private VBox horarioGeneradoContainer;
    @FXML
    private Text mensajeNoMasPropuestas;
    @FXML
    private TabPane PaneDocente;
    @FXML
    private Tab tabDisponibilidad;
    @FXML
    private Tab tabHorarioGenerado;
    @FXML
    private Tab tabReporte;
    @FXML
    private Label idnombre;
    @FXML
    private Label docentecodigo;
    @FXML
    private Label docentecorreo;
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
    private TableView<Curso> tableCursoDisponible;
    @FXML
    private TableColumn<Curso, String> colCursoDisponible;
    @FXML
    private TableColumn<Curso, String> colHoraDisponible;
    @FXML
    private TableView<Curso> tableCursoElegido;
    @FXML
    private TableColumn<Curso, String> colCursoElegido;
    @FXML
    private TableColumn<Curso, String> colHoraElegido;

    public DocenteController() {
    }

    public void initialize() {

        Persona usuarioActual = Sesion.getInstancia().getUsuarioActual();

        if (usuarioActual != null) {
            System.out.println("Usuario en sesión: " + usuarioActual.getNombre());

            if (usuarioActual instanceof Docente) {
                // Configura la interfaz o realiza acciones específicas para Docente

                configurarVistaParaDocente((Docente) usuarioActual);
                idnombre.setText(usuarioActual.getNombre());
                docentecodigo.setText(usuarioActual.getCodigo());
                docentecorreo.setText(usuarioActual.getCorreo());

                this.dbCurso = new DBCursos();
                this.dbCurso.inicializarCursos();
                this.colCursoDisponible.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.colHoraDisponible.setCellValueFactory(new PropertyValueFactory("horasSemana"));
                this.colCursoElegido.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.colHoraElegido.setCellValueFactory(new PropertyValueFactory("horasSemana"));
                this.cargarCursosDisponibles();
                this.cargarCursosElegidos();
                this.cargarCursosDisponibles();
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

    private void cargarCursosDisponibles() {
        this.tableCursoDisponible.getItems().clear();
        // Crear un Set para almacenar los nombres de los cursos y evitar duplicados
        Set<String> nombresCursos = new HashSet<>();

        // Iterar sobre los cursos disponibles
        for (Curso curso : this.dbCurso.getCursosDisponibles()) {
            // Verificar si el nombre del curso ya está en el Set
            if (!nombresCursos.contains(curso.getNombre())) {
                // Si no está, agregar el curso a la lista de la tabla y añadir su nombre al Set
                this.tableCursoDisponible.getItems().add(curso);
                nombresCursos.add(curso.getNombre());
            }
        }
        //this.tableCursoDisponible.getItems().addAll(this.dbCurso.getCursosDisponibles());
    }

    @FXML
    private void ElegirCursoAction(ActionEvent event) {
        // Obtener el curso seleccionado de la tabla de cursos disponibles
        Curso cursoSeleccionado = this.tableCursoDisponible.getSelectionModel().getSelectedItem();

        if (cursoSeleccionado != null) {
            // Mover el curso a los elegidos (esto lo hace tu método en DB)
            this.dbCurso.moverCursoAElegidos(cursoSeleccionado.getCodigo());

            // Eliminar todas las secciones de ese curso de la lista de cursos disponibles
            this.dbCurso.eliminarSeccionesCurso(cursoSeleccionado.getNombre());

            // Actualizar las vistas de cursos disponibles y elegidos
            this.cargarCursosDisponibles();
            this.cargarCursosElegidos();
        }
    }

    private void cargarCursosElegidos() {
        this.tableCursoElegido.getItems().clear();
        this.tableCursoElegido.getItems().addAll(this.dbCurso.getCursosElegidos());
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

    @FXML
    private void generarReporte(ActionEvent event) {
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

}
