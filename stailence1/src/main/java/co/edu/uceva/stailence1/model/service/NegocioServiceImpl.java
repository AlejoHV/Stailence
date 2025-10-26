package co.edu.uceva.stailence1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uceva.stailence1.model.dao.INegocioDao;
import co.edu.uceva.stailence1.model.entities.Negocio;

import java.util.List;

@Service
public class NegocioServiceImpl implements INegocioService {

    @Autowired
    private INegocioDao negocioDao;

    @Override
    public List<Negocio> findAll() {
        return negocioDao.findAll();
    }

    @Override
    public Negocio save(Negocio negocio) {
        return negocioDao.save(negocio);
    }

    @Override
    public void delete(Long id) {
        negocioDao.deleteById(id);
    }

    @Override
    public Negocio findById(Long id) {
        return negocioDao.findById(id).orElse(null);
    }
}