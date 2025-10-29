package co.edu.uceva.stailence1.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import co.edu.uceva.stailence1.model.dao.IUsuarioDao;
import co.edu.uceva.stailence1.model.dto.RegistroUsuarioRequest;
import co.edu.uceva.stailence1.model.entities.Usuarios;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioDao usuarioDao;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(IUsuarioDao usuarioDao, PasswordEncoder passwordEncoder) {
        this.usuarioDao = usuarioDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuarios> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuarios save(Usuarios usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Usuarios findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public Optional<Usuarios> findByCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    public Usuarios registrar(RegistroUsuarioRequest request) {
        if (!request.getContrasena().equals(request.getConfirmarContrasena())) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }

        usuarioDao.findByCorreo(request.getCorreo()).ifPresent(usuario -> {
            throw new IllegalStateException("Ya existe un usuario registrado con ese correo");
        });
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombre(request.getNombre());
        nuevoUsuario.setApellido(request.getApellido());
        nuevoUsuario.setCorreo(request.getCorreo());
        nuevoUsuario.setContrasena(passwordEncoder.encode(request.getContrasena()));
        nuevoUsuario.setRol(Usuarios.Rol.cliente);

        return usuarioDao.save(nuevoUsuario);
    }
}