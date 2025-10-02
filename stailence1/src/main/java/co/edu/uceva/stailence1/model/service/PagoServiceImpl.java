package co.edu.uceva.stailence1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uceva.stailence1.model.dao.IPagoDao;
import co.edu.uceva.stailence1.model.entities.Pago;

import java.util.List;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private IPagoDao pagoDao;

    @Override
    public List<Pago> findAll() {
        return pagoDao.findAll();
    }

    @Override
    public Pago save(Pago pago) {
        return pagoDao.save(pago);
    }

    @Override
    public void delete(Long id) {
        pagoDao.deleteById(id);
    }

    @Override
    public Pago findById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }
}