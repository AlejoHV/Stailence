package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Disponibilidad;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiaSemana dia;

    @Column(nullable = false)
    private java.time.LocalTime hora_inicio;

    @Column(nullable = false)
    private java.time.LocalTime hora_fin;

    // Relación con Usuario (Empleado)
    @ManyToOne
    @JoinColumn(name = "id_Empleado", nullable = false)
    private Usuarios empleado;

    // ===== Getters y Setters =====
    public Long getId_Disponibilidad() {
        return id_Disponibilidad;
    }

    public void setId_Disponibilidad(Long id_Disponibilidad) {
        this.id_Disponibilidad = id_Disponibilidad;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public java.time.LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(java.time.LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public java.time.LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(java.time.LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Usuarios getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuarios empleado) {
        this.empleado = empleado;
    }
}