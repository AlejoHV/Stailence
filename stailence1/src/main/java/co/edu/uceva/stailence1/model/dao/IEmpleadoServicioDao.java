package co.edu.uceva.stailence1.model.dao;

import co.edu.uceva.stailence1.model.entities.EmpleadoServicio;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoServicioDao extends JpaRepository<EmpleadoServicio, EmpleadoServicioId> {
    // Método para buscar por ID de servicio
    @Query("SELECT es FROM EmpleadoServicio es WHERE es.id_Empleado.id_Servicio = :idServicio")
    List<EmpleadoServicio> findByServicioId(@Param("idServicio") Long idServicio);

    // Método para buscar por ID de empleado
    @Query("SELECT es FROM EmpleadoServicio es WHERE es.id_Empleado.id_Empleado = :idEmpleado")
    List<EmpleadoServicio> findByEmpleadoId(@Param("idEmpleado") Long idEmpleado);

}