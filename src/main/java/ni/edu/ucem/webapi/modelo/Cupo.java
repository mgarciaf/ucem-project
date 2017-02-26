
package ni.edu.ucem.webapi.modelo;

import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Cupo {
  private Integer id;
    
   @NotNull
   @NotEmpty(message= "La fecha de ingreso es Requerida")
   private Timestamp fechaIngreso;
   
   @NotNull
   @NotEmpty(message= "La fecha de salida es Requerida")
   private Timestamp fechaSalida;
   
   @NotNull(message = "La categoria es Requerida.")
   @Range(min = 1, max = 1000)
   private Integer categoria;
   
   public Cupo(){
   }
   
    public Cupo(final Timestamp fechaIngreso, final Timestamp fechaSalida, final Integer categoria) 
    {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.categoria = categoria;
    }
    
    public Cupo(final Integer id, final Timestamp fechaIngreso, final Timestamp fechaSalida, final Integer categoria) 
    {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.categoria = categoria;
    }
    
    public Integer getId() {
      return id;
    }
    public void setId(Integer id) {
     this.id = id;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
      
}
