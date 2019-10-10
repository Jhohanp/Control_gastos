package com.example.controldegastos.ui.main;

public class Efectivo {

    private String Fecha, Descripcion;
    private int Monto,CodEfectivo;

    public Efectivo(int codEfectivo,String fecha, String descripcion, int monto) {
        Fecha = fecha;
        Descripcion = descripcion;
        Monto = monto;
        CodEfectivo = codEfectivo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int monto) {
        Monto = monto;
    }

    public int getCodEfectivo() {
        return CodEfectivo;
    }

    public void setCodEfectivo(int codEfectivo) {
        CodEfectivo = codEfectivo;
    }
}
