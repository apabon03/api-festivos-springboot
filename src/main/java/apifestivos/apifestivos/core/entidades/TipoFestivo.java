package apifestivos.apifestivos.core.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo")
public class TipoFestivo {
    
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "tipo", length = 200, nullable = false)
    private String tipoFestivo;

    public TipoFestivo() {
    }

    public TipoFestivo(int id, String tipoFestivo) {
        this.id = id;
        this.tipoFestivo = tipoFestivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoFestivo() {
        return tipoFestivo;
    }

    public void setTipoFestivo(String tipoFestivo) {
        this.tipoFestivo = tipoFestivo;
    }

     
}