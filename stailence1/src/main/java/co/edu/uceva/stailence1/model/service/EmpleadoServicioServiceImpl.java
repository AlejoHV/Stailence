package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.dao.IEmpleadoServicioDao;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicio;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicioId;
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

    @Override
    public List<EmpleadoServicio> findByServicioId(Long idServicio) {
        return empleadoServicioDao.findByServicioId(idServicio);
    }

    @Override
    public List<EmpleadoServicio> findByEmpleadoId(Long idEmpleado) {
        return empleadoServicioDao.findByEmpleadoId(idEmpleado);
    }
}