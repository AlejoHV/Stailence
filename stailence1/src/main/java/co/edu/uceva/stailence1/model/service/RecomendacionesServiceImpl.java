package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.dao.IRecomendacionesDao;
import co.edu.uceva.stailence1.model.entities.Recomendaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacionesServiceImpl implements IRecomendacionesService {

    @Autowired
    private IRecomendacionesDao recomendacionesDao;

    @Override
    public List<Recomendaciones> findAll() {
        return recomendacionesDao.findAll();
    }

    @Override
    public Recomendaciones findById(Long id) {
        return recomendacionesDao.findById(id).orElse(null);
    }

    @Override
    public Recomendaciones save(Recomendaciones recomendacion) {
        return recomendacionesDao.save(recomendacion);
    }

    @Override
    public void delete(Long id) {
        recomendacionesDao.deleteById(id);
    }
}