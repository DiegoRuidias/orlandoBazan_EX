package com.examen.exu3_orlandobazan.Model;

public class CitaRequest {
    private String fecha;
    private String hora;
    private String nombre_paciente;

    public CitaRequest(String fecha, String hora, String nombre_paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombre_paciente = nombre_paciente;
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

    public String getNombrePaciente() {
        return nombre_paciente;
    }

    public void setNombrePaciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }
}
