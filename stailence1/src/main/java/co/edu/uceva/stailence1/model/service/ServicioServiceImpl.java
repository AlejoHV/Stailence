package co.edu.uceva.stailence1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uceva.stailence1.model.dao.IServicioDao;
import co.edu.uceva.stailence1.model.entities.Servicio;

import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    private IServicioDao servicioDao;

    @Override
    public List<Servicio> findAll() {
        return servicioDao.findAll();
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioDao.save(servicio);
    }

    @Override
    public void delete(Long id) {
        servicioDao.deleteById(id);
    }

    @Override
    public Servicio findById(Long id) {
        return servicioDao.findById(id).orElse(null);
    }
}