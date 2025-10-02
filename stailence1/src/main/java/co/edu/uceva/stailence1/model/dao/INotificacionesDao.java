package com.stailence.backend.dao;

import com.stailence.backend.entities.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificacionesDao extends JpaRepository<Notificaciones, Long> {
}