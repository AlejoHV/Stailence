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
    private Long id_Citas;

    @Column(name = "fecha_estimada", nullable = false)
    private LocalDate fecha_estimada;

    @Column(name = "hora_estipulada", nullable = false)
    private LocalTime hora_estipulada;

    @Column(name = "fecha_real")
    private LocalDateTime fecha_real;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    // Relación con el empleado
    @ManyToOne
    @JoinColumn(name = "id_Empleado")
    private Usuarios empleado;

    // Relación con el servicio
    @ManyToOne
    @JoinColumn(name = "id_Servicio")
    private Servicios servicio;

    // Relación con el cliente
    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Usuarios cliente;

    public enum Estado {
        reservada,
        cancelada,
        completada,
        reprogramada
    }

    // Getters y Setters
    public Long getId() {
        return id_Citas;
    }
    public void setId(Long id) {
        this.id_Citas = id;
    }

    public LocalDate getFechaEstimada() {
        return fecha_estimada;
    }
    public void setFechaEstimada(LocalDate fechaEstimada) {
        this.fecha_estimada = fechaEstimada;
    }

    public LocalTime getHoraEstipulada() {
        return hora_estipulada;
    }
    public void setHoraEstipulada(LocalTime horaEstipulada) {
        this.hora_estipulada = horaEstipulada;
    }

    public LocalDateTime getFechaReal() {
        return fecha_real;
    }
    public void setFechaReal(LocalDateTime fechaReal) {
        this.fecha_real = fechaReal;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public Usuarios getCliente() {
        return cliente;
    }
    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }
}