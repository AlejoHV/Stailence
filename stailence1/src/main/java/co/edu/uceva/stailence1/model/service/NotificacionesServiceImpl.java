package com.stailence.backend.service;

import com.stailence.backend.dao.INotificacionesDao;
import com.stailence.backend.entities.Notificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionesServiceImpl implements INotificacionesService {

    @Autowired
    private INotificacionesDao notificacionesDao;

    @Override
    public List<Notificaciones> findAll() {
        return notificacionesDao.findAll();
    }

    @Override
    public Notificaciones findById(Long id) {
        return notificacionesDao.findById(id).orElse(null);
    }

    @Override
    public Notificaciones save(Notificaciones notificacion) {
        return notificacionesDao.save(notificacion);
    }

    @Override
    public void delete(Long id) {
        notificacionesDao.deleteById(id);
    }
}