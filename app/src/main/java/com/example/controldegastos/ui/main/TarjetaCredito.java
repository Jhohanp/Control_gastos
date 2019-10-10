package com.example.controldegastos.ui.main;

public class TarjetaCredito {

    private String Tipo;
    private int Digitos,Cupo,Cuota;
    private double Interes;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getDigitos() {
        return Digitos;
    }

    public void setDigitos(int digitos) {
        Digitos = digitos;
    }

    public int getCupo() {
        return Cupo;
    }

    public void setCupo(int cupo) {
        Cupo = cupo;
    }

    public int getCuota() {
        return Cuota;
    }

    public void setCuota(int cuota) {
        Cuota = cuota;
    }

    public double getInteres() {
        return Interes;
    }

    public void setInteres(double interes) {
        Interes = interes;
    }

    public TarjetaCredito( int digitos,String tipo, int cupo, int cuota, double interes) {
        Tipo = tipo;
        Digitos = digitos;
        Cupo = cupo;
        Cuota = cuota;
        Interes = interes;


    }
}
