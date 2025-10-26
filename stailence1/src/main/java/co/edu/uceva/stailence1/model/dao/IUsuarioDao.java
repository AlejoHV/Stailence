package co.edu.uceva.stailence1.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uceva.stailence1.model.entities.Usuarios;

public interface IUsuarioDao extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByCorreo(String correo);
}