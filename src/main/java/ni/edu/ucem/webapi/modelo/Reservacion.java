
package ni.edu.ucem.webapi.modelo;

import java.sql.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Reservacion {
    
    private Integer id;
    
   @NotNull
   @NotEmpty(message= "La fecha es Requerida")
   private Date desde;
   
   @NotNull
   @NotEmpty(message= "La fecha es Requerida")
   private Date hasta;
   
   @NotNull(message = "El id del cuarto es requerida.")
   @Range(min = 1, max = 1000)
   private Integer cuarto;
   
   @NotNull(message = "El id del huesped es requerida.")
   @Range(min = 1, max = 1000)
   private Integer huesped;

    public Reservacion() {
    }

    public Integer getId() {
        return id;
    }

    public Date getDesde() {
        return desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public void setCuarto(Integer cuarto) {
        this.cuarto = cuarto;
    }

    public void setHuesped(Integer huesped) {
        this.huesped = huesped;
    }

    public Integer getCuarto() {
        return cuarto;
    }

    public Integer getHuesped() {
        return huesped;
    }

    public Reservacion(Date desde, Date hasta, Integer cuarto, Integer huesped) {
        this.desde = desde;
        this.hasta = hasta;
        this.cuarto = cuarto;
        this.huesped = huesped;
    }

    public Reservacion(Integer id, Date desde, Date hasta, Integer cuarto, Integer huesped) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.cuarto = cuarto;
        this.huesped = huesped;
    }
    
}
