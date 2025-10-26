package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Usuarios;
import java.util.List;

public interface IUsuarioService {
    List<Usuarios> findAll();
    Usuarios save(Usuarios usuario);
    void delete(Long id);
    Usuarios findById(Long id);
}