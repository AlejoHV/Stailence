package com.stailence.backend.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoServicioId implements Serializable {

    private Long idEmpleado;
    private Long idServicio;

    // Getters, Setters, hashCode y equals
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpleadoServicioId)) return false;
        EmpleadoServicioId that = (EmpleadoServicioId) o;
        return Objects.equals(idEmpleado, that.idEmpleado) &&
                Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, idServicio);
    }
}