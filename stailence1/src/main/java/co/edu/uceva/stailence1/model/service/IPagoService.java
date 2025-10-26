package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Pago;
import java.util.List;

public interface IPagoService {
    List<Pago> findAll();
    Pago save(Pago pago);
    void delete(Long id);
    Pago findById(Long id);
}