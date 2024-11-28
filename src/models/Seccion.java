package models;


public class Seccion {
    private int NumSecc;
    private int dia;
    private int periodoI;
    private int periodoF; 
    private boolean asignada;

    public Seccion(int NumSecc, int dia, int periodoI, int periodoF) {
        this.NumSecc = NumSecc;
        this.dia = dia;
        this.periodoI = periodoI;
        this.periodoF = periodoF;
        this.asignada = false;
    }

    public int getNumSecc() {
        return NumSecc;
    }

    public int getDia() {
        return dia;
    }

    public int getPeriodoI() {
        return periodoI;
    }

    public int getPeriodoF() {
        return periodoF;
    }

    public void setNumSecc(int NumSecc) {
        this.NumSecc = NumSecc;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setPeriodoI(int periodoI) {
        this.periodoI = periodoI;
    }

    public void setPeriodoF(int periodoF) {
        this.periodoF = periodoF;
    }
    
    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }
    
}