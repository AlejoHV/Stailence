package co.edu.uceva.stailence1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uceva.stailence1.model.dao.ITipoUsuarioDao;
import co.edu.uceva.stailence1.model.entities.TipoUsuario;
import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {

    @Autowired
    private ITipoUsuarioDao tipoUsuarioDao;

    @Override
    public List<TipoUsuario> findAll() {
        return tipoUsuarioDao.findAll();
    }

    @Override
    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioDao.save(tipoUsuario);
    }

    @Override
    public void delete(Long id) {
        tipoUsuarioDao.deleteById(id);
    }

    @Override
    public TipoUsuario findById(Long id) {
        return tipoUsuarioDao.findById(id).orElse(null);
    }
}
