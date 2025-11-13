package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.EmpleadoServicio;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicioId;

import java.util.List;

public interface IEmpleadoServicioService {
    List<EmpleadoServicio> findAll();
    EmpleadoServicio findById(EmpleadoServicioId id);
    EmpleadoServicio save(EmpleadoServicio empleadoServicio);
    void delete(EmpleadoServicioId id);

    // Nuevos métodos
    List<EmpleadoServicio> findByServicioId(Long idServicio);
    List<EmpleadoServicio> findByEmpleadoId(Long idEmpleado);
}