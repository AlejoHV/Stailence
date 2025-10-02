package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoServicioId implements Serializable {

    private Long id_Empleado;
    private Long id_Servicio;

    // Getters, Setters, hashCode y equals
    /*
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
     */

    public EmpleadoServicioId() {}

    // 🔹 Constructor con parámetros (necesario para tu código)
    public EmpleadoServicioId(Long idEmpleado, Long idServicio) {
        this.id_Empleado = idEmpleado;
        this.id_Servicio = idServicio;
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