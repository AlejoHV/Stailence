package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Servicios")
    private Long id;

    @Column(name = "nombre_servicio", nullable = false, length = 150)
    private String nombreServicio;

    @Column(name = "duracion_servicio", nullable = false)
    private int duracionServicio;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double precio;

    // Relación con Negocio (Muchos servicios pertenecen a un negocio)
    @ManyToOne
    @JoinColumn(name = "id_Negocio")
    private Negocio negocio;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getDuracionServicio() {
        return duracionServicio;
    }
    public void setDuracionServicio(int duracionServicio) {
        this.duracionServicio = duracionServicio;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Negocio getNegocio() {
        return negocio;
    }
    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }
}