package com.stailence.backend.dao;

import com.stailence.backend.entities.EmpleadoServicio;
import com.stailence.backend.entities.EmpleadoServicioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoServicioDao extends JpaRepository<EmpleadoServicio, EmpleadoServicioId> {
}