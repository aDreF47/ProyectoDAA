package models;

public class Curso {
    private String codigo;
    private String nombre;
    private int maxAlumnos;
    private int horasSemana;
    private int seccion;
    private int creditos;
    private Ciclo ciclo;
    
     
    public String getCodigo() {
        return codigo;
    }
  
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public int getMaxAlumnos() {
        return maxAlumnos;
    }
   
    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }
    
    public int getSeccion() {
        return seccion;
    }
    
    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }
   
    public int getCreditos() {
        return creditos;
    }
    
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    public Ciclo getCiclo() {
        return ciclo;
    }
   
    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    public Curso(String codigo, String nombre, int maxAlumnos, int horasSemana, int seccion, int creditos, Ciclo ciclo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.maxAlumnos = maxAlumnos;
        this.horasSemana = horasSemana;
        this.seccion = seccion;
        this.creditos = creditos;
        this.ciclo = ciclo;
    }
    
}