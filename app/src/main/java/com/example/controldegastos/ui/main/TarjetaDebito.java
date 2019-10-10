package com.example.controldegastos.ui.main;

public class TarjetaDebito {

    private String Tipo;
    private int Digitos,Disponible,Cuota;

    public TarjetaDebito(String tipo, int digitos, int disponible, int cuota) {
        Tipo = tipo;
        Digitos = digitos;
        Disponible = disponible;
        Cuota = cuota;
    }

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

    public int getDisponible() {
        return Disponible;
    }

    public void setDisponible(int disponible) {
        Disponible = disponible;
    }

    public int getCuota() {
        return Cuota;
    }

    public void setCuota(int cuota) {
        Cuota = cuota;
    }
}
