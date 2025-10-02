package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado_servicio")
public class EmpleadoServicio {

    @EmbeddedId
    private EmpleadoServicioId id_Empleado;

    // Relación con Usuario (Empleado)
    @ManyToOne
    @MapsId("id_Empleado")
    @JoinColumn(name = "id_Empleado")
    private Usuarios empleado;

    // Relación con Servicio
    @ManyToOne
    @MapsId("id_Servicio")
    @JoinColumn(name = "id_Servicio")
    private Servicios servicio;

    // Getters y Setters
    public EmpleadoServicioId getId() {
        return id_Empleado;
    }

    public void setId(EmpleadoServicioId id) {
        this.id_Empleado = id;
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