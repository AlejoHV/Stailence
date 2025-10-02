package com.stailence.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleado_Servicio")
public class EmpleadoServicio {

    @EmbeddedId
    private EmpleadoServicioId id;

    // Relación con Usuario (Empleado)
    @ManyToOne
    @MapsId("idEmpleado")
    @JoinColumn(name = "id_Empleado")
    private Usuarios empleado;

    // Relación con Servicio
    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "id_Servicio")
    private Servicios servicio;

    // Getters y Setters
    public EmpleadoServicioId getId() {
        return id;
    }

    public void setId(EmpleadoServicioId id) {
        this.id = id;
    }

    public Usuarios getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuarios empleado) {
        this.empleado = empleado;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }
}