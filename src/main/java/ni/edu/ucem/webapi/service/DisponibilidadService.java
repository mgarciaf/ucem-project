
package ni.edu.ucem.webapi.service;

import ni.edu.ucem.webapi.modelo.Cupo;
import ni.edu.ucem.webapi.modelo.Filtro;
import ni.edu.ucem.webapi.modelo.Pagina;

public interface DisponibilidadService {
  public Pagina<Cupo> obtenerTodos(final Filtro paginacion);
}
