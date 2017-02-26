
package ni.edu.ucem.webapi.reservacion;

import javax.validation.Valid;
import ni.edu.ucem.webapi.core.ApiResponse;
import ni.edu.ucem.webapi.core.ApiResponse.Status;
import ni.edu.ucem.webapi.core.ListApiResponse;
import ni.edu.ucem.webapi.modelo.Reservacion;
import ni.edu.ucem.webapi.serviceImpl.ReservacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/reservaciones")
public class ReservacionResource {
    
      private final ReservacionServiceImpl reservacionService;
  
    @Autowired
    public ReservacionResource(final ReservacionServiceImpl reservacionService)
    {
        this.reservacionService = reservacionService;
    }
    
    
    @RequestMapping(value = "reservacion-id", method = RequestMethod.GET, produces="application/json")
    public ApiResponse obtener(@PathVariable("reservacion-id") final int id)
    {
        final Reservacion reservacion = this.reservacionService.obtenerReservacion(id);
        return new ApiResponse(Status.OK, reservacion);        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST,
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse guardarReservacion(@Valid @RequestBody final Reservacion reservacion, BindingResult result) 
    {
        if(result.hasErrors())
        {
            throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
        }
        
        this.reservacionService.agregarReservacion(reservacion);
        return new ApiResponse(Status.OK, reservacion);
    }
        
}
