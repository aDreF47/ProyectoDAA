package models;

public class Sesion {
    private static Sesion instancia;
    private Persona usuarioActual;

    private Sesion() {
        // Constructor privado para evitar instanciación directa
    }

    // Método para obtener la única instancia de Sesion
    public static Sesion getInstancia() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }

    // Método para establecer el usuario actual
    public void iniciarSesion(Persona usuario) {
        this.usuarioActual = usuario;
    }

    // Método para cerrar sesión
    public void cerrarSesion() {
        this.usuarioActual = null;
    }

    // Método para obtener el usuario actual
    public Persona getUsuarioActual() {
        return usuarioActual;
    }

    // Verifica si hay un usuario en sesión
    public boolean hayUsuarioEnSesion() {
        return usuarioActual != null;
    }
}
