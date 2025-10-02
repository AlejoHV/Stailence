package com.stailence.backend.service;

import com.stailence.backend.dao.IEmpleadoServicioDao;
import com.stailence.backend.entities.EmpleadoServicio;
import com.stailence.backend.entities.EmpleadoServicioId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioServiceImpl implements IEmpleadoServicioService {

    @Autowired
    private IEmpleadoServicioDao empleadoServicioDao;

    @Override
    public List<EmpleadoServicio> findAll() {
        return empleadoServicioDao.findAll();
    }

    @Override
    public EmpleadoServicio findById(EmpleadoServicioId id) {
        return empleadoServicioDao.findById(id).orElse(null);
    }

    @Override
    public EmpleadoServicio save(EmpleadoServicio empleadoServicio) {
        return empleadoServicioDao.save(empleadoServicio);
    }

    @Override
    public void delete(EmpleadoServicioId id) {
        empleadoServicioDao.deleteById(id);
    }
}