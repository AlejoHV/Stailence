package co.edu.uceva.stailence1.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "negocios")
public class Negocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_Negocios")
    private Long id_Negocios;   // mapea id_Negocios

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;

    @Column(unique = true)
    @JsonProperty("correo")
    private String correo;

    @Column(name = "horario_general")
    @JsonProperty("horario_general")
    private String horario_general;

    // Getters y Setters
    public Long getId() {
        return id_Negocios;
    }
    public void setId_Negocios(Long id) {
        this.id_Negocios = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorarioGeneral() {
        return horario_general;
    }

    public void setHorarioGeneral(String horarioGeneral) {
        this.horario_general = horarioGeneral;
    }
}