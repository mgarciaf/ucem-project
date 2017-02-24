package ni.edu.ucem.webapi.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class CategoriaCuarto 
{
    private Integer id;
    
    @NotNull
    @NotEmpty(message= "Nombre de Categoria Requerido")
    @Pattern(regexp="^[\\w ]+$")
    private String nombre;
    
    @NotNull
    @NotEmpty(message="La descripcion es requerida")
    @Pattern(regexp = "^[\\w ]+$")
    private String descripcion;
    
    @NotNull(message="Precio de categoria Requerido")
    //Expresion regular para entero
    //@Pattern(regexp = "[\\d ]+$")
    private BigDecimal precio;
    
    private Date fecha = new Date();
        
    public CategoriaCuarto(){}
    
    public CategoriaCuarto( final String nombre, 
            final String descripcion,final BigDecimal precio) 
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public CategoriaCuarto(final Integer id, final String nombre, 
            final String descripcion,final BigDecimal precio) 
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }
}
