package co.edu.uceva.stailence1.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uceva.stailence1.model.entities.Cita;

public interface ICitaDao extends JpaRepository<Cita, Long> {
}