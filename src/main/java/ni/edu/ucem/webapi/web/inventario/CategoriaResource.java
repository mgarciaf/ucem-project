
package ni.edu.ucem.webapi.web.inventario;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ni.edu.ucem.webapi.core.ApiResponse;
import ni.edu.ucem.webapi.core.ApiResponse.Status;
import ni.edu.ucem.webapi.core.ListApiResponse;
import ni.edu.ucem.webapi.modelo.CategoriaCuarto;
import ni.edu.ucem.webapi.modelo.Filtro;
import ni.edu.ucem.webapi.modelo.Pagina;
import ni.edu.ucem.webapi.serviceImpl.InventarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/v1/inventario/categorias")
public class CategoriaResource
{
    private final InventarioServiceImpl categoriaService;
    
     @Autowired
    public CategoriaResource(final InventarioServiceImpl categoriaService)
    {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(method = RequestMethod.GET,produces="application/json")
    public ListApiResponse<CategoriaCuarto> obtenerCategorias(
        @RequestParam(value = "offset", required = false, defaultValue ="0") final Integer offset,
        @RequestParam(value = "limit", required = false, defaultValue="0") final Integer limit)
    {
        final Filtro paginacion = new Filtro.Builder()
        .paginacion(offset, limit)
        .build();
        
        Pagina<CategoriaCuarto> pagina;
        pagina = this.categoriaService.obtenerCategoria(paginacion);
        return new ListApiResponse<CategoriaCuarto>(Status.OK, pagina);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
    public ApiResponse obtener(@PathVariable("id") final int id)
    {
        final CategoriaCuarto categoria = this.categoriaService.obtenerCategoriaCuarto(id);
        return new ApiResponse(Status.OK, categoria);        
    }
    
    @RequestMapping(method = RequestMethod.POST,
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse guardarCategoria(@RequestBody final CategoriaCuarto categoria) 
    {
        this.categoriaService.agregarCategoriaCuarto(categoria);
        return new ApiResponse(Status.OK, categoria);
    }
    
    @RequestMapping(method= RequestMethod.POST, 
            produces = "application/json",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse guardarCategoriaCuartoFormParameters(
            final String nombre, 
            final String descripcion, 
            final BigDecimal precio){
        final CategoriaCuarto categoria = new CategoriaCuarto(nombre, descripcion, precio);
         this.categoriaService.agregarCategoriaCuarto(categoria);
        return new ApiResponse(Status.OK, categoria);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            produces="application/json")    
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse guardarCategoria(@PathVariable("id") final int id, 
            @RequestBody final CategoriaCuarto categoriaActualizado) 
    {
        final CategoriaCuarto categoria = new CategoriaCuarto(id,
                categoriaActualizado.getNombre(), 
                categoriaActualizado.getDescripcion(),
                categoriaActualizado.getPrecio());
        this.categoriaService.agregarCategoriaCuarto(categoria);
        return new ApiResponse(Status.OK, categoria);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, 
            produces="application/json")
    public ApiResponse eliminarCategoria(@PathVariable("id") final int id) 
    {
        final CategoriaCuarto categoria = this.categoriaService.obtenerCategoriaCuarto(id);
        this.categoriaService.eliminarCategoriaCuarto(categoria.getId());
        return new ApiResponse(Status.OK,null);
    }
    
}
