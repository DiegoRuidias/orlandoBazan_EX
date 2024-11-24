package com.examen.exu3_orlandobazan.Model;

public class CitaRequest {
    private int id;
    private String fecha;
    private String hora;
    private String nombre_paciente;
    private String estado;

    public CitaRequest(String fecha, String hora, String nombre_paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombre_paciente = nombre_paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setNombrePaciente(String nombrePaciente) {
        this.nombre_paciente = nombrePaciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
