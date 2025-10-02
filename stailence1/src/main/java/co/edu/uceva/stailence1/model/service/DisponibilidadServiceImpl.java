package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.dao.IDisponibilidadDao;
import co.edu.uceva.stailence1.model.entities.Disponibilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadServiceImpl implements IDisponibilidadService {

    @Autowired
    private IDisponibilidadDao disponibilidadDao;

    @Override
    public List<Disponibilidad> findAll() {
        return disponibilidadDao.findAll();
    }

    @Override
    public Disponibilidad findById(Long id) {
        return disponibilidadDao.findById(id).orElse(null);
    }

    @Override
    public Disponibilidad save(Disponibilidad disponibilidad) {
        return disponibilidadDao.save(disponibilidad);
    }

    @Override
    public void delete(Long id) {
        disponibilidadDao.deleteById(id);
    }
}