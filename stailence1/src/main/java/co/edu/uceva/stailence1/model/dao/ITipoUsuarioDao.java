package co.edu.uceva.stailence1.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uceva.stailence1.model.entities.TipoUsuario;

public interface ITipoUsuarioDao extends JpaRepository<TipoUsuario, Long> {
}
