package co.edu.uceva.stailence1.model.dao;

import co.edu.uceva.stailence1.model.entities.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisponibilidadDao extends JpaRepository<Disponibilidad, Long> {
}