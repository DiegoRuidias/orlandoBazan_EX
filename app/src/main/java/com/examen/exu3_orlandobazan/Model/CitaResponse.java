package com.examen.exu3_orlandobazan.Model;

public class CitaResponse {
    private int cita_id;
    private String fecha;
    private String hora;
    private String nombre_paciente;

    public int getCitaId() {
        return cita_id;
    }

    public void setCitaId(int cita_id) {
        this.cita_id = cita_id;
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
