package models;

import java.util.ArrayList;
import java.util.List;

public class DBCursos {

    private List<Curso> cursosDisponibles; // Cursos aún no seleccionados
    private List<Curso> cursosElegidos;    // Cursos seleccionados

    public DBCursos() {
        cursosDisponibles = new ArrayList<>();
        cursosElegidos = new ArrayList<>();
    }

    public void inicializarCursos() {
         // Creamos los cursos disponibles y les asignamos varias secciones
        Curso curso1 = new Curso("C001", "Matemáticas", 30, 5, 4, Ciclo.UNO);
        curso1.agregarSeccion(new Seccion(1, 1, 3, 5)); // Sección 1
        curso1.agregarSeccion(new Seccion(2, 2, 4, 6)); // Sección 2
        cursosDisponibles.add(curso1);

        Curso curso2 = new Curso("C002", "Física", 25, 4, 2, Ciclo.DOS);
        curso2.agregarSeccion(new Seccion(2, 1, 2, 4)); // Sección 1
        curso2.agregarSeccion(new Seccion(2, 2, 3, 5)); // Sección 2
        cursosDisponibles.add(curso2);

        Curso curso3 = new Curso("C003", "Química", 35, 6, 1, Ciclo.TRES);
        curso3.agregarSeccion(new Seccion(3, 1, 1, 3)); // Sección 1
        curso3.agregarSeccion(new Seccion(3, 2, 2, 4)); // Sección 2
        cursosDisponibles.add(curso3);

        // Continuar con el resto de cursos...
        Curso curso4 = new Curso("C004", "Historia", 20, 3, 3, Ciclo.CUATRO);
        curso4.agregarSeccion(new Seccion(4, 1, 2, 3)); // Sección 1
        cursosDisponibles.add(curso4);

        // Repite el proceso para los demás cursos
        cursosDisponibles.add(new Curso("C005", "Programación", 40, 7, 1, Ciclo.CINCO));
        cursosDisponibles.add(new Curso("C006", "Ingeniería de Software", 50, 6, 2, Ciclo.SEIS));
        cursosDisponibles.add(new Curso("C007", "Inteligencia Artificial", 35, 5, 3, Ciclo.SIETE));
        cursosDisponibles.add(new Curso("C008", "Sistemas Operativos", 30, 5, 1, Ciclo.OCHO));
        cursosDisponibles.add(new Curso("C009", "Redes", 25, 4, 2, Ciclo.NUEVE));
        cursosDisponibles.add(new Curso("C010", "Base de Datos", 35, 6, 3, Ciclo.DIEZ));

    }

    public boolean moverCursoAElegidos(String codigoCurso) {
        Curso curso = cursosDisponibles.stream()
                .filter(c -> c.getCodigo().equals(codigoCurso))
                .findFirst()
                .orElse(null);

        if (curso != null) {
            cursosDisponibles.remove(curso);
            cursosElegidos.add(curso);
            return true;
        }
        return false;
    }

    // Método para mover un curso de elegidos a disponibles
    public boolean moverCursoADisponibles(String codigoCurso) {
        Curso curso = cursosElegidos.stream()
                .filter(c -> c.getCodigo().equals(codigoCurso))
                .findFirst()
                .orElse(null);

        if (curso != null) {
            cursosElegidos.remove(curso);
            cursosDisponibles.add(curso);
            return true;
        }
        return false;
    }

    // Getters para las listas
    public List<Curso> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public List<Curso> getCursosElegidos() {
        return cursosElegidos;
    }

    public void eliminarSeccionesCurso(String nombreCurso) {
        // Filtrar los cursos disponibles eliminando los cursos con el mismo nombre
        this.cursosDisponibles.removeIf(curso -> curso.getNombre().equals(nombreCurso));
    }
    // Método para mover un curso de disponibles a elegidos  

}