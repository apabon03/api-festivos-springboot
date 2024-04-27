package apifestivos.apifestivos.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivos.apifestivos.core.entidades.TablaFestivos;


@Repository
public interface ITablaFestivosRepositorio extends JpaRepository<TablaFestivos, Integer> {

    /* 
    @Query("SELECT s FROM Seleccion s WHERE s.nombre LIKE '%' || ?1 || '%'")
    public List<Seleccion> buscar(String nombre);
    */
}
