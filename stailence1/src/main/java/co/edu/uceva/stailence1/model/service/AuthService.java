package co.edu.uceva.stailence1.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.uceva.stailence1.model.dto.LoginRequest;
import co.edu.uceva.stailence1.model.dto.LoginResponse;
import co.edu.uceva.stailence1.model.entities.Usuarios;
import co.edu.uceva.stailence1.security.JwtService;

@Service
public class AuthService {

    private final IUsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(IUsuarioService usuarioService,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        Usuarios usuario = usuarioService.findByCorreo(request.getCorreo())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));

        if (!passwordEncoder.matches(request.getContrasena(), usuario.getContrasena())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(usuario);
        return new LoginResponse(token, usuario.getNombre(), usuario.getCorreo());
    }
}
