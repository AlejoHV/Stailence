package co.edu.uceva.stailence1.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uceva.stailence1.model.entities.Servicios;

public interface IServicioDao extends JpaRepository<Servicios, Long> {
}