package co.edu.uceva.stailence1.model.dao;

import co.edu.uceva.stailence1.model.entities.Recomendaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecomendacionesDao extends JpaRepository<Recomendaciones, Long> {
}