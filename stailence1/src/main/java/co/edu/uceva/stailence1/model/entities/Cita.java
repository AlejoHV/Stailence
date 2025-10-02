package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Citas")
    private Long id;

    @Column(name = "fecha_estimada", nullable = false)
    private LocalDate fechaEstimada;

    @Column(name = "hora_estipulada", nullable = false)
    private LocalTime horaEstipulada;

    @Column(name = "fecha_real")
    private LocalDateTime fechaReal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    // Relación con el empleado
    @ManyToOne
    @JoinColumn(name = "id_Empleado")
    private Usuario empleado;

    // Relación con el servicio
    @ManyToOne
    @JoinColumn(name = "id_Servicio")
    private Servicio servicio;

    // Relación con el cliente
    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Usuario cliente;

    public enum Estado {
        reservada,
        cancelada,
        completada,
        reprogramada
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaEstimada() {
        return fechaEstimada;
    }
    public void setFechaEstimada(LocalDate fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public LocalTime getHoraEstipulada() {
        return horaEstipulada;
    }
    public void setHoraEstipulada(LocalTime horaEstipulada) {
        this.horaEstipulada = horaEstipulada;
    }

    public LocalDateTime getFechaReal() {
        return fechaReal;
    }
    public void setFechaReal(LocalDateTime fechaReal) {
        this.fechaReal = fechaReal;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Usuario getCliente() {
        return cliente;
    }
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}