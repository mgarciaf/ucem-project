
package ni.edu.ucem.webapi.web.inventario;

import ni.edu.ucem.webapi.core.ApiResponse.Status;
import ni.edu.ucem.webapi.core.ListApiResponse;
import ni.edu.ucem.webapi.modelo.Cupo;
import ni.edu.ucem.webapi.modelo.Filtro;
import ni.edu.ucem.webapi.modelo.Pagina;
import ni.edu.ucem.webapi.serviceImpl.DisponibilidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        @RequestParam(value = "offset", required = false, defaultValue ="0") final Integer offset,
        @RequestParam(value = "limit", required = false, defaultValue="0") final Integer limit)
    {
        final Filtro paginacion = new Filtro.Builder()
        .paginacion(offset, limit)
        .build();
        
        Pagina<Cupo> pagina;
        pagina = this.cupoService.obtenerTodos(paginacion);
        return new ListApiResponse<Cupo>(Status.OK, pagina);
    }
    
}
