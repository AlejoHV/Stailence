package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    void delete(Long id);
    Usuario findById(Long id);
}