
package ni.edu.ucem.webapi.serviceImpl;

import ni.edu.ucem.webapi.dao.ReservacionDAO;
import ni.edu.ucem.webapi.modelo.Reservacion;
import ni.edu.ucem.webapi.service.ReservacionService;
import org.springframework.stereotype.Service;

@Service
public class ReservacionServiceImpl implements ReservacionService {
    
    private final ReservacionDAO reservacionDAO;
    
    public ReservacionServiceImpl(final ReservacionDAO reservacionDAO){
        this.reservacionDAO = reservacionDAO;
    }

    public Reservacion obtenerReservacion(final Integer pId) {
      if (pId < 0) 
        {
            throw new IllegalArgumentException("ID inválido. debe ser mayor a cero.");
        }
        return this.reservacionDAO.obtenerPorId(pId); 
    }

    public void agregarReservacion(final Reservacion preservacion) {
        this.reservacionDAO.agregar(preservacion);
    }
    
}
