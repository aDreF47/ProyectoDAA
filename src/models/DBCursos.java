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
        cursosDisponibles.add(new Curso("C001", "Matemáticas", 30, 5, 1, 4, Ciclo.UNO));
        cursosDisponibles.add(new Curso("C002", "Física", 25, 4, 2, 3, Ciclo.DOS));
        cursosDisponibles.add(new Curso("C003", "Química", 35, 6, 1, 4, Ciclo.TRES));
        cursosDisponibles.add(new Curso("C004", "Historia", 20, 3, 3, 2, Ciclo.CUATRO));
        cursosDisponibles.add(new Curso("C005", "Programación", 40, 7, 1, 5, Ciclo.CINCO));
        cursosDisponibles.add(new Curso("C006", "Ingeniería de Software", 50, 6, 2, 4, Ciclo.SEIS));
        cursosDisponibles.add(new Curso("C007", "Inteligencia Artificial", 35, 5, 3, 5, Ciclo.SIETE));
        cursosDisponibles.add(new Curso("C008", "Sistemas Operativos", 30, 5, 1, 4, Ciclo.OCHO));
        cursosDisponibles.add(new Curso("C009", "Redes", 25, 4, 2, 3, Ciclo.NUEVE));
        cursosDisponibles.add(new Curso("C010", "Base de Datos", 35, 6, 3, 4, Ciclo.DIEZ));

        cursosDisponibles.add(new Curso("C001", "Matemáticas", 30, 5, 2, 4, Ciclo.UNO));
        cursosDisponibles.add(new Curso("C002", "Física", 25, 4, 1, 3, Ciclo.DOS));
        cursosDisponibles.add(new Curso("C003", "Química", 35, 6, 2, 4, Ciclo.TRES));
        cursosDisponibles.add(new Curso("C004", "Historia", 20, 3, 2, 2, Ciclo.CUATRO));
        cursosDisponibles.add(new Curso("C005", "Programación", 40, 7, 1, 5, Ciclo.CINCO));
        cursosDisponibles.add(new Curso("C006", "Ingeniería de Software", 50, 6, 1, 4, Ciclo.SEIS));
        cursosDisponibles.add(new Curso("C007", "Inteligencia Artificial", 35, 5, 1, 5, Ciclo.SIETE));
        cursosDisponibles.add(new Curso("C008", "Sistemas Operativos", 30, 5, 2, 4, Ciclo.OCHO));
        cursosDisponibles.add(new Curso("C009", "Redes", 25, 4, 1, 3, Ciclo.NUEVE));
        cursosDisponibles.add(new Curso("C010", "Base de Datos", 35, 6, 1, 4, Ciclo.DIEZ));

    }

    // Método para mover un curso de disponibles a elegidos
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

}
