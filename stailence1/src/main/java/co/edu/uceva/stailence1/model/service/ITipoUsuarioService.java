package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.TipoUsuario;
import java.util.List;

public interface ITipoUsuarioService {
    List<TipoUsuario> findAll();
    TipoUsuario save(TipoUsuario tipoUsuario);
    void delete(Long id);
    TipoUsuario findById(Long id);
}
