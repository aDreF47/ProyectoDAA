package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import models.Docente;
import models.Estudiante;
import models.Persona;
import models.Sesion;
import models.Sistema;

public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField txtPasswordVisible; // Campo para mostrar la contraseña visible
    @FXML
    private CheckBox rememberMeCheck;
    @FXML
    private ImageView logoImage;
    @FXML
    private ImageView newsImage;
    @FXML
    private HBox dotsContainer;
    @FXML
    private Hyperlink registerLink;

    private List<Image> newsImages = new ArrayList<>();
    private int currentImageIndex = 0;
    private Timeline newsTimeline;

    private Sistema sistema; // Reference to Sistema
    
    private final String PROPERTIES_FILE = "src/files/config.properties";
    @FXML
    private ImageView eyeIcon;
    
    private BooleanProperty isPasswordVisible = new SimpleBooleanProperty(false);

    public void initialize() {
        sistema = new Sistema(); // Initialize Sistema to manage data
        cargarCredenciales();

        registerLink.setOnAction(event -> {
            try {
                openWebpage("https://mail.google.com/");
            } catch (URISyntaxException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Load logo and background images
        logoImage.setImage(new Image("file:src/imagen/logo.jpg"));
        newsImages.add(new Image("file:src/imagen/RSfisi.png"));
        newsImages.add(new Image("file:src/imagen/pc.jpeg"));
        newsImages.add(new Image("file:src/imagen/nolsatrabajo.png"));

        updateNewsImage();
        
        // Sincronizar la visibilidad de los campos de contraseña
        txtPasswordVisible.managedProperty().bind(isPasswordVisible);
        txtPasswordVisible.visibleProperty().bind(isPasswordVisible);
        txtPasswordVisible.textProperty().bindBidirectional(passwordField.textProperty());
        
        passwordField.managedProperty().bind(isPasswordVisible.not());
        passwordField.visibleProperty().bind(isPasswordVisible.not());
        // Setting initial state for the eye icon
        eyeIcon.setImage(new Image(getClass().getResourceAsStream("/imagen/eye-icon.png")));

        // Start automatic news image rotation
        newsTimeline = new Timeline(new KeyFrame(Duration.seconds(10), event -> nextNews()));
        newsTimeline.setCycleCount(Timeline.INDEFINITE);
        newsTimeline.play();
    }

     @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean rememberMe = rememberMeCheck.isSelected();

        // Verificar credenciales y acceder
        if (sistema.verificarAcceso(email, password)) {
            System.out.println("Acceso concedido.");

            // Guardar credenciales si "Remember Me" está seleccionado
            if (rememberMe) {
                guardarCredenciales(email, password);
            } else {
                borrarCredenciales();
            }

            // Redirigir a la vista correspondiente
            Persona usuarioActual = sistema.obtenerPersonaPorCorreo(email);
            
            // Inicia la sesión estableciendo el usuario actual en la instancia de Sesion
            Sesion.getInstancia().iniciarSesion(usuarioActual);
            if (usuarioActual instanceof Estudiante) {
                abrirVentana("/views/EstudianteView.fxml", "Estudiante");
            } else if (usuarioActual instanceof Docente) {
                abrirVentana("/views/DocenteView.fxml", "Docente");
            }

        } else {
            System.out.println("Acceso denegado. Usuario o contraseña incorrectos.");
        }
    }
    
    private void guardarCredenciales(String email, String password) {
        try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.setProperty("email", email);
            prop.setProperty("password", password);
            prop.store(output, null);
            System.out.println("Credenciales guardadas.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarCredenciales() {
        try (FileInputStream input = new FileInputStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);

            String email = prop.getProperty("email");
            String password = prop.getProperty("password");

            if (email != null && password != null) {
                emailField.setText(email);
                passwordField.setText(password);
                rememberMeCheck.setSelected(true);
            }
        } catch (IOException e) {
            System.out.println("No hay credenciales guardadas.");
        }
    }

    private void borrarCredenciales() {
        try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.clear();
            prop.store(output, null);
            System.out.println("Credenciales borradas.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void abrirVentana(String fxmlPath, String titulo) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Crea un nuevo Stage para la nueva vista
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle(titulo);
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.centerOnScreen();
            nuevaVentana.show();

            // Cierra la ventana actual de inicio de sesión
            Stage loginStage = (Stage) emailField.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateNewsImage() {
        newsImage.setImage(newsImages.get(currentImageIndex));
        updateDots();
    }

    @FXML
    private void nextNews() {
        currentImageIndex = (currentImageIndex + 1) % newsImages.size();
        updateNewsImage();
    }

    @FXML
    private void previousNews() {
        currentImageIndex = (currentImageIndex - 1 + newsImages.size()) % newsImages.size();
        updateNewsImage();
    }

    private void updateDots() {
        dotsContainer.getChildren().clear();
        for (int i = 0; i < newsImages.size(); i++) {
            Button dot = new Button("●");
            dot.setStyle("-fx-font-size: 8px;  -fx-background-color: transparent;");
            if (i == currentImageIndex) {
                dot.setStyle("-fx-font-size: 10px; -fx-text-fill: black;");
            }
            dotsContainer.getChildren().add(dot);
        }
    }

    private void openWebpage(String url) throws URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void togglePasswordVisibility() {
        isPasswordVisible.set(!isPasswordVisible.get());

        if (isPasswordVisible.get()) {
            eyeIcon.setImage(new Image(getClass().getResourceAsStream("/imagen/eye-slash-icon.png")));
        } else {
            eyeIcon.setImage(new Image(getClass().getResourceAsStream("/imagen/eye-icon.png")));
        }
    }
}
