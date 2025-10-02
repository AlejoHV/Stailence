package com.stailence.backend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notificaciones")
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Notificaciones;

    @Column(nullable = false, length = 255)
    private String mensaje_recordatorio;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoNotificacion estado_notificacion;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "id_Usuario", nullable = false)
    private Usuarios usuario;

    // Relación con Cita
    @ManyToOne
    @JoinColumn(name = "id_Cita")
    private Citas cita;

    // ===== Enum interno =====
    public enum EstadoNotificacion {
        pendiente, enviada, vista
    }

    // ===== Getters y Setters =====
    public Long getId_Notificaciones() {
        return id_Notificaciones;
    }

    public void setId_Notificaciones(Long id_Notificaciones) {
        this.id_Notificaciones = id_Notificaciones;
    }

    public String getMensaje_recordatorio() {
        return mensaje_recordatorio;
    }

    public void setMensaje_recordatorio(String mensaje_recordatorio) {
        this.mensaje_recordatorio = mensaje_recordatorio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoNotificacion getEstado_notificacion() {
        return estado_notificacion;
    }

    public void setEstado_notificacion(EstadoNotificacion estado_notificacion) {
        this.estado_notificacion = estado_notificacion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }
}