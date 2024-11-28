package models;

import java.util.ArrayList;
import java.util.List;

public class DBCursos {

    private List<Curso> cursosDisponibles; // Cursos aún no seleccionados
    private List<Curso> cursosElegidos;    // Cursos seleccionados
    private List<Disponibilidad> disponibilidades;

    public DBCursos() {
        cursosDisponibles = new ArrayList<>();
        cursosElegidos = new ArrayList<>();
        disponibilidades = new ArrayList<>();
    }

    public void inicializarCursos() {
        // Creamos los cursos disponibles y les asignamos varias secciones
        Curso curso1 = new Curso("20118037", "Matemáticas Discreta", 30, 4, 3, Ciclo.CUATRO);
        curso1.agregarSeccion(new Seccion(1, 1, 8, 12)); // Sección 1
        curso1.agregarSeccion(new Seccion(2, 2, 8, 12)); // Sección 2
        cursosDisponibles.add(curso1);

        Curso curso2 = new Curso("INO205", "Física I", 35, 5, 4, Ciclo.DOS);
        curso2.agregarSeccion(new Seccion(1, 1, 8, 13)); // Sección 1
        curso2.agregarSeccion(new Seccion(2, 2, 8, 13)); // Sección 2
        cursosDisponibles.add(curso2);

        Curso curso3 = new Curso("INO206", "Química General", 35, 5, 4, Ciclo.DOS);
        curso3.agregarSeccion(new Seccion(1, 4, 8, 13)); // Sección 1
        curso3.agregarSeccion(new Seccion(2, 3, 14, 19)); // Sección 2
        cursosDisponibles.add(curso3);

        // Continuar con el resto de cursos...
        Curso curso4 = new Curso("20118035", "Estadistica", 30, 4, 4, Ciclo.TRES);
        curso4.agregarSeccion(new Seccion(1, 3, 8, 12)); // Sección 1
        curso4.agregarSeccion(new Seccion(2, 5, 14, 18)); // Sección 1
        cursosDisponibles.add(curso4);

        // Repite el proceso para los demás cursos
        Curso curso5 = new Curso("INE002 ", "Programación y Computación", 40, 3, 2, Ciclo.UNO);
        curso5.agregarSeccion(new Seccion(1, 3, 8, 12)); // Sección 1
        curso5.agregarSeccion(new Seccion(2, 5, 14, 18)); // Sección 1
        cursosDisponibles.add(curso5);

        Curso curso6 = new Curso("INE013", "Emprendimiento e Innovación", 45, 3, 2, Ciclo.DOS);
        curso6.agregarSeccion(new Seccion(1, 3, 8, 11)); // Sección 1
        curso6.agregarSeccion(new Seccion(2, 4, 14, 17)); // Sección 2
        cursosDisponibles.add(curso6);

        Curso curso7 = new Curso("INO104", "Cálculo I", 35, 4, 4, Ciclo.UNO);
        curso7.agregarSeccion(new Seccion(1, 2, 8, 12)); // Sección 1
        curso7.agregarSeccion(new Seccion(2, 5, 14, 18)); // Sección 2
        curso7.agregarSeccion(new Seccion(3, 6, 14, 18)); // Sección 3
        cursosDisponibles.add(curso7);

        Curso curso8 = new Curso("INO204", "Cálculo II", 35, 4, 4, Ciclo.DOS);
        curso8.agregarSeccion(new Seccion(1, 6, 8, 12)); // Sección 1
        curso8.agregarSeccion(new Seccion(2, 2, 8, 12)); // Sección 2
        cursosDisponibles.add(curso8);

        Curso curso9 = new Curso("INO207", "Introducción a las Ciencias e Ingeniería", 35, 2, 3, Ciclo.DOS);
        curso9.agregarSeccion(new Seccion(1, 1, 8, 11)); // Sección 1
        curso9.agregarSeccion(new Seccion(2, 3, 9, 12)); // Sección 2
        cursosDisponibles.add(curso9);

        Curso curso10 = new Curso("20118034", "Ingeniería Económica", 35, 4, 3, Ciclo.TRES);
        curso10.agregarSeccion(new Seccion(1, 2, 8, 11)); // Sección 1
        curso10.agregarSeccion(new Seccion(2, 4, 15, 18)); // Sección 2
        cursosDisponibles.add(curso10);

        Curso curso11 = new Curso("20118031", "Programación y Fundamentos de Algorítmica", 40, 5, 4, Ciclo.TRES);
        curso11.agregarSeccion(new Seccion(1, 2, 8, 13)); // Sección 1
        curso11.agregarSeccion(new Seccion(2, 4, 14, 19)); // Sección 2
        curso11.agregarSeccion(new Seccion(3, 6, 14, 19)); // Sección 2
        cursosDisponibles.add(curso11);

        Curso curso12 = new Curso("20118036", "Series y Ecuaciones Diferenciales", 40, 5, 3, Ciclo.TRES);
        curso12.agregarSeccion(new Seccion(1, 1, 8, 12)); // Sección 1
        curso12.agregarSeccion(new Seccion(2, 5, 14, 18)); // Sección 2
        cursosDisponibles.add(curso12);

        Curso curso13 = new Curso("20118041", "Algorítmica y Programación Orientada a Objetos", 40, 5, 4, Ciclo.CUATRO);
        curso13.agregarSeccion(new Seccion(1, 2, 8, 13)); // Sección 1
        curso13.agregarSeccion(new Seccion(2, 3, 14, 19)); // Sección 2
        curso13.agregarSeccion(new Seccion(3, 4, 8, 13)); // Sección 2
        cursosDisponibles.add(curso13);

        Curso curso14 = new Curso("20118043", "Contabilidad General", 40, 4, 4, Ciclo.CUATRO);
        curso14.agregarSeccion(new Seccion(1, 3, 8, 12)); // Sección 1
        curso14.agregarSeccion(new Seccion(2, 5, 14, 18)); // Sección 2
        cursosDisponibles.add(curso14);

        Curso curso15 = new Curso("20118047", "Física Electrónica", 40, 5, 4, Ciclo.CUATRO);
        curso15.agregarSeccion(new Seccion(1, 1, 8, 13)); // Sección 1
        curso15.agregarSeccion(new Seccion(2, 3, 14, 19)); // Sección 2
        cursosDisponibles.add(curso15);

        Curso curso16 = new Curso("20118056", "Arquitectura de Computadoras", 40, 4, 5, Ciclo.CINCO);
        curso16.agregarSeccion(new Seccion(1, 3, 8, 12)); // Sección 1
        curso16.agregarSeccion(new Seccion(2, 6, 14, 18)); // Sección 2
        cursosDisponibles.add(curso16);

        Curso curso17 = new Curso("20118055", "Modelos y Simulación", 40, 3, 4, Ciclo.CINCO);
        curso17.agregarSeccion(new Seccion(1, 2, 8, 12)); // Sección 1
        curso17.agregarSeccion(new Seccion(2, 3, 8, 12)); // Sección 2
        cursosDisponibles.add(curso17);

        Curso curso18 = new Curso("20118075", "Inteligencia Artificial", 35, 4, 3, Ciclo.SIETE);
        curso18.agregarSeccion(new Seccion(1, 5, 14, 18)); // Sección 1
        curso18.agregarSeccion(new Seccion(2, 2, 14, 18)); // Sección 2
        cursosDisponibles.add(curso18);

        Curso curso19 = new Curso("20118067", "Sistemas Operativos", 30, 4, 3, Ciclo.SEIS);
        curso19.agregarSeccion(new Seccion(1, 5, 8, 12)); // Sección 1
        curso19.agregarSeccion(new Seccion(2, 6, 8, 12)); // Sección 2
        cursosDisponibles.add(curso19);

        Curso curso20 = new Curso("20118066", "Redes", 35, 4, 4, Ciclo.SEIS);
        curso20.agregarSeccion(new Seccion(1, 3, 14, 18)); // Sección 1
        curso20.agregarSeccion(new Seccion(2, 6, 14, 18)); // Sección 2
        cursosDisponibles.add(curso20);

        Curso curso21 = new Curso("20118051", "Base de Datos", 40, 5, 4, Ciclo.CINCO);
        curso21.agregarSeccion(new Seccion(1, 4, 8, 13)); // Sección 1
        curso21.agregarSeccion(new Seccion(2, 1, 12, 17)); // Sección 2
        cursosDisponibles.add(curso21);

        Curso curso22 = new Curso("20118071", "Interacción Hombre Computador", 40, 4, 3, Ciclo.SIETE);
        curso22.agregarSeccion(new Seccion(1, 5, 14, 18)); // Sección 1
        curso22.agregarSeccion(new Seccion(2, 2, 14, 18)); // Sección 2
        cursosDisponibles.add(curso22);
        
        // Ejemplo de disponibilidad del docente
        disponibilidades.add(new Disponibilidad(1, 8, 14)); // Lunes de 8:00 a 14:00
        disponibilidades.add(new Disponibilidad(2, 8, 12)); // Martes de 8:00 a 12:00
        disponibilidades.add(new Disponibilidad(3, 9, 13)); // Miércoles de 9:00 a 13:00
        // Aquí se pueden agregar más disponibilidades del docente

    }

    // Métodos para agregar y eliminar cursos y disponibilidades
    public void agregarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidades.add(disponibilidad);
    }

    public void eliminarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidades.remove(disponibilidad);
    }

    public List<Curso> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public List<Curso> getCursosElegidos() {
        return cursosElegidos;
    }

    public List<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
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

    // Generar horario para los cursos seleccionados
    public boolean generarHorario() {
        int horasTotales = 0; // Sumar las horas de los cursos asignados

        // Para cada curso seleccionado
        for (Curso curso : cursosElegidos) {
            boolean seccionAsignada = false; // Bandera para verificar si ya se asignó una sección
            for (Seccion seccion : curso.getSecciones()) {
                // Verificar si la sección está disponible
                if (!seccion.isAsignada() && !verificarConflicto(seccion)) {
                    // Verificar que el docente tenga disponibilidad para el día y hora de la sección
                    if (verificarDisponibilidad(seccion)) {
                        // Verificar que no superemos las 13 horas
                        if (horasTotales + curso.getHorasSemana() <= 13) {
                            // Asignar la sección
                            seccion.setAsignada(true);
                            horasTotales += curso.getHorasSemana(); // Sumar las horas del curso asignado
                            seccionAsignada = true;
                            System.out.println("Sección asignada: " + curso.getNombre() + " - Sección " + seccion.getNumSecc());
                            break; // Salir del bucle de secciones ya que solo asignamos una
                        } else {
                            System.out.println("No se puede asignar la sección de " + curso.getNombre() + " - Sección " + seccion.getNumSecc() + " debido a la restricción de horas.");
                        }
                    } else {
                        System.out.println("El docente no tiene disponibilidad para la sección de " + curso.getNombre() + " - Sección " + seccion.getNumSecc());
                    }
                }
            }

            // Si no se pudo asignar ninguna sección, avisamos
            if (!seccionAsignada) {
                System.out.println("No se pudo asignar ninguna sección de " + curso.getNombre());
            }
        }

        // Verificar si hemos asignado correctamente las horas
        if (horasTotales > 13) {
            System.out.println("Error: El total de horas asignadas excede las 13 horas permitidas.");
            return false;
        }

        return true; // El horario se generó correctamente
    }

// Verificar si la sección se ajusta a la disponibilidad del docente
    private boolean verificarDisponibilidad(Seccion seccion) {
    System.out.println("Verificando disponibilidad para la sección: " + seccion.getNumSecc());
    for (Disponibilidad disponibilidad : disponibilidades) {
        System.out.println("Disponibilidad: Día " + disponibilidad.getDia() + ", De " +
                           disponibilidad.getHoraInicio() + " a " + disponibilidad.getHoraFin());
        // Verificar si el docente tiene disponibilidad para el día y las horas de la sección
        if (disponibilidad.getDia() == seccion.getDia() &&
            seccion.getPeriodoI() >= disponibilidad.getHoraInicio() &&
            seccion.getPeriodoF() <= disponibilidad.getHoraFin()) {
            return true; // El docente tiene disponibilidad
        }
    }
    return false; // El docente no tiene disponibilidad
}



// Verificar si ya existe un conflicto de horarios
    private boolean verificarConflicto(Seccion nuevaSeccion) {
    for (Curso curso : cursosElegidos) {
        for (Seccion seccion : curso.getSecciones()) {
            // Verificar si las secciones tienen el mismo día y hora
            if (seccion.isAsignada() && seccion.getDia() == nuevaSeccion.getDia()
                    && ((nuevaSeccion.getPeriodoI() >= seccion.getPeriodoI() && nuevaSeccion.getPeriodoI() < seccion.getPeriodoF())
                    || (nuevaSeccion.getPeriodoF() > seccion.getPeriodoI() && nuevaSeccion.getPeriodoF() <= seccion.getPeriodoF()))) {
                return true; // Hay conflicto
            }
        }
    }
    return false; // No hay conflicto
}


// Método para verificar si las secciones se solapan
    private boolean esSolapamiento(Seccion seccionExistente, Seccion nuevaSeccion) {
        // Verificar si las horas se solapan
        return !(nuevaSeccion.getPeriodoF() <= seccionExistente.getPeriodoI() || nuevaSeccion.getPeriodoI() >= seccionExistente.getPeriodoF());
    }

    public void eliminarSeccionesCurso(String nombreCurso) {
        // Filtrar los cursos disponibles eliminando los cursos con el mismo nombre
        this.cursosDisponibles.removeIf(curso -> curso.getNombre().equals(nombreCurso));
    }

    

}
