package models;

public class Disponibilidad {
    private int dia;         // Día de la semana (1 = Lunes, 7 = Domingo)
    private int horaInicio;  // Hora de inicio de la disponibilidad
    private int horaFin;     // Hora de fin de la disponibilidad

    public Disponibilidad(int dia, int horaInicio, int horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Disponibilidad{dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
}
