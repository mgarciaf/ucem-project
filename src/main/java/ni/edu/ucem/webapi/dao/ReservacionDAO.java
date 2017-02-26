
package ni.edu.ucem.webapi.dao;

import ni.edu.ucem.webapi.modelo.Reservacion;

public interface ReservacionDAO {

    public Reservacion obtenerPorId(final int pId);

    public void agregar(Reservacion preservacion);
    
}
