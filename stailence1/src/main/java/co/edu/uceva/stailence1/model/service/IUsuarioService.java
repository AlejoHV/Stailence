package co.edu.uceva.stailence1.model.service;

import java.util.List;
import java.util.Optional;

import co.edu.uceva.stailence1.model.dto.RegistroUsuarioRequest;
import co.edu.uceva.stailence1.model.entities.Usuarios;

public interface IUsuarioService {
    List<Usuarios> findAll();
    Usuarios save(Usuarios usuario);
    void delete(Long id);
    Usuarios findById(Long id);
    Optional<Usuarios> findByCorreo(String correo);
    Usuarios registrar(RegistroUsuarioRequest request);
}