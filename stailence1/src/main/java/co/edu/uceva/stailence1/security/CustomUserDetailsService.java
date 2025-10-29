package co.edu.uceva.stailence1.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.uceva.stailence1.model.dao.IUsuarioDao;
import co.edu.uceva.stailence1.model.entities.Usuarios;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IUsuarioDao usuarioDao;

    public CustomUserDetailsService(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuarioDao.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String role = usuario.getRol() != null ? usuario.getRol().name() : "cliente";

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())));
    }
}
