package com.example.controldegastos.ui.main;

public class Gasto {
    private String CodGasto, Categoria, fecha, hora, metodoPago,Descripcion;
    private  int  MontoGasto, FrecDiaria;

    public Gasto(String codGasto, String categoria, String fecha, String hora, String metodoPago, String descripcion, int montoGasto, int frecDiaria) {
        CodGasto = codGasto;
        Categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.metodoPago = metodoPago;
        Descripcion = descripcion;
        MontoGasto = montoGasto;
        FrecDiaria = frecDiaria;
    }

    public String getCodGasto() {
        return CodGasto;
    }

    public void setCodGasto(String codGasto) {
        CodGasto = codGasto;
    }

    public int getMontoGasto() {
        return MontoGasto;
    }

    public void setMontoGasto(int montoGasto) {
        MontoGasto = montoGasto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getFrecDiaria() {
        return FrecDiaria;
    }

    public void setFrecDiaria(int frecDiaria) {
        FrecDiaria = frecDiaria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "CodGasto='" + CodGasto + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", MontoGasto=" + MontoGasto +
                ", FrecDiaria=" + FrecDiaria +
                '}';
    }
}
