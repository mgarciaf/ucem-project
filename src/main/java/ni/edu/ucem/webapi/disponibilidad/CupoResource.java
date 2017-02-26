
package ni.edu.ucem.webapi.disponibilidad;

import java.sql.Timestamp;
import javax.validation.Valid;
import ni.edu.ucem.webapi.core.ApiResponse;
import ni.edu.ucem.webapi.core.ApiResponse.Status;
import ni.edu.ucem.webapi.core.ListApiResponse;
import ni.edu.ucem.webapi.modelo.Cupo;
import ni.edu.ucem.webapi.modelo.Filtro;
import ni.edu.ucem.webapi.modelo.Pagina;
import ni.edu.ucem.webapi.serviceImpl.DisponibilidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/disponibilidad/cupos")
public class CupoResource {
    
  private final DisponibilidadServiceImpl cupoService;
  
    @Autowired
    public CupoResource(final DisponibilidadServiceImpl cupoService)
    {
        this.cupoService = cupoService;
    }
    
    @RequestMapping(method = RequestMethod.GET,produces="application/json")
    public ListApiResponse<Cupo> obtenerCupos(
        //@RequestParam(value = "fechaIngreso", required = true) final Timestamp fechaIngreso,
        //@RequestParam(value = "fechaSalida", required = true) final Timestamp fechaSalida,
        @RequestParam(value = "categoria", required = false) final Integer categoria,
        @RequestParam(value = "offset", required = false, defaultValue ="0") final Integer offset,
        @RequestParam(value = "limit", required = false, defaultValue="0") final Integer limit)
    {
        final Filtro paginacion = new Filtro.Builder()
        .paginacion(offset, limit)
        .build();
        
        Pagina<Cupo> pagina;
        if(categoria != null)
        {
            pagina = this.cupoService.obtenerTodosCupoEnCategoria(categoria, paginacion);
        }
        else
        {
            pagina = this.cupoService.obtenerTodos(paginacion);
        }
        
        return new ListApiResponse<Cupo>(Status.OK, pagina);
    }
    
    @PreAuthorize("hasRole('ADMIN')")     
    @RequestMapping(method = RequestMethod.POST,
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse guardarCupo(@Valid @RequestBody final Cupo cupo, BindingResult result) 
    {
        if(result.hasErrors())
        {
            throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
        }
        this.cupoService.agregarCupo(cupo);
        return new ApiResponse(Status.OK, cupo);
    }
    
}
