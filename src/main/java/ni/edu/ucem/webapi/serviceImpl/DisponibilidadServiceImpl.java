
package ni.edu.ucem.webapi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import ni.edu.ucem.webapi.dao.CupoDAO;
import ni.edu.ucem.webapi.modelo.Cupo;
import ni.edu.ucem.webapi.modelo.Filtro;
import ni.edu.ucem.webapi.modelo.Pagina;
import ni.edu.ucem.webapi.service.DisponibilidadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {
    
    private final CupoDAO cupoDAO;
    
    public DisponibilidadServiceImpl(final CupoDAO cupoDAO){
        this.cupoDAO = cupoDAO;
    }

    @Override
    public Pagina<Cupo> obtenerTodos(Filtro paginacion) 
    {
        List<Cupo> cupos;
        final int count = this.cupoDAO.contar();
        if(count > 0)
        {
            cupos = this.cupoDAO.obtenerTodos(paginacion.getOffset(),
                    paginacion.getLimit());
        }
        else
        {
            cupos = new ArrayList<Cupo>();
        }
        return new Pagina<Cupo>(cupos, count,  paginacion.getOffset(), paginacion.getLimit());
    }

    @Transactional
    public void agregarCupo(final Cupo pcupo) {
      this.cupoDAO.agregar(pcupo);
    }

    public Pagina<Cupo> obtenerTodosCupoEnCategoria(final int pCategoriaCuartoId, final Filtro paginacion) {
        final int count = this.cupoDAO.contarPorCategoria(pCategoriaCuartoId);
        List<Cupo> cupos = null;
                if(count > 0)
        {
            cupos = this.cupoDAO.obtenerTodosPorCategoriaId(pCategoriaCuartoId, paginacion.getOffset(),
                    paginacion.getLimit());
        }
        else
        {
            cupos = new ArrayList<Cupo>();
        }
        return new Pagina<Cupo>(cupos, count,  paginacion.getOffset(), paginacion.getLimit());
    }

}
