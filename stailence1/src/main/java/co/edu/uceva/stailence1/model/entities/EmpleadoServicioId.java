package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoServicioId implements Serializable {

    private Long id_Empleado;
    private Long id_Servicio;

    public EmpleadoServicioId() {
    }

    public EmpleadoServicioId(Long id_Empleado, Long id_Servicio) {
        this.id_Empleado = id_Empleado;
        this.id_Servicio = id_Servicio;
    }

    public Long getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(Long id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public Long getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(Long id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpleadoServicioId)) return false;
        EmpleadoServicioId that = (EmpleadoServicioId) o;
        return Objects.equals(id_Empleado, that.id_Empleado) &&
                Objects.equals(id_Servicio, that.id_Servicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Empleado, id_Servicio);
    }
}