package co.edu.uceva.stailence1.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recomendaciones")
public class Recomendaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Recomendaciones;

    @Column(length = 100)
    private String tipo_rostro;

    @Column(length = 150)
    private String corte_sugerido;

    // Relación con Usuario (Cliente)
    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    private Usuarios cliente;

    // ===== Getters y Setters =====
    public Long getId_Recomendaciones() {
        return id_Recomendaciones;
    }

    public void setId_Recomendaciones(Long id_Recomendaciones) {
        this.id_Recomendaciones = id_Recomendaciones;
    }

    public String getTipo_rostro() {
        return tipo_rostro;
    }

    public void setTipo_rostro(String tipo_rostro) {
        this.tipo_rostro = tipo_rostro;
    }

    public String getCorte_sugerido() {
        return corte_sugerido;
    }

    public void setCorte_sugerido(String corte_sugerido) {
        this.corte_sugerido = corte_sugerido;
    }

    public Usuarios getCliente() {
        return cliente;
    }

    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }
}