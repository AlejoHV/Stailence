package co.edu.uceva.stailence1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uceva.stailence1.model.dao.ICitaDao;
import co.edu.uceva.stailence1.model.entities.Cita;

import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaDao citaDao;

    @Override
    public List<Cita> findAll() {
        return citaDao.findAll();
    }

    @Override
    public Cita save(Cita cita) {
        return citaDao.save(cita);
    }

    @Override
    public void delete(Long id) {
        citaDao.deleteById(id);
    }

    @Override
    public Cita findById(Long id) {
        return citaDao.findById(id).orElse(null);
    }
}