package co.edu.uceva.stailence1.model.dao;

import co.edu.uceva.stailence1.model.entities.EmpleadoServicio;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoServicioDao extends JpaRepository<EmpleadoServicio, EmpleadoServicioId> {
}