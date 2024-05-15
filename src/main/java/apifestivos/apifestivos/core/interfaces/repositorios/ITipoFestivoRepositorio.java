package apifestivos.apifestivos.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivos.apifestivos.core.entidades.TipoFestivo;

@Repository
public interface ITipoFestivoRepositorio extends JpaRepository<TipoFestivo, Integer> {

}