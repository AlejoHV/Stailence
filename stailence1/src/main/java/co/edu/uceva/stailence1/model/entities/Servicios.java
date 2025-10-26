package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Servicios")
    private Long id_Servicios;

    @Column(name = "nombre_servicio", nullable = false, length = 150)
    private String nombre_servicio;

    @Column(name = "duracion_servicio", nullable = false)
    private int duracion_servicio;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    // Relación con Negocio (Muchos servicios pertenecen a un negocio)
    @ManyToOne
    @JoinColumn(name = "id_Negocio")
    private Negocio negocio;

    // Getters y Setters
    public Long getId() {
        return id_Servicios;
    }
    public void setId(Long id) {
        this.id_Servicios = id;
    }

    public String getNombreServicio() {
        return nombre_servicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombre_servicio = nombreServicio;
    }

    public int getDuracionServicio() {
        return duracion_servicio;
    }
    public void setDuracionServicio(int duracionServicio) {
        this.duracion_servicio = duracionServicio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Negocio getNegocio() {
        return negocio;
    }
    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }
}