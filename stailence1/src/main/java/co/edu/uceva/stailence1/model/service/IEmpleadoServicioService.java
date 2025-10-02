package com.stailence.backend.service;

import com.stailence.backend.entities.EmpleadoServicio;
import com.stailence.backend.entities.EmpleadoServicioId;

import java.util.List;

public interface IEmpleadoServicioService {
    List<EmpleadoServicio> findAll();
    EmpleadoServicio findById(EmpleadoServicioId id);
    EmpleadoServicio save(EmpleadoServicio empleadoServicio);
    void delete(EmpleadoServicioId id);
}