
package ni.edu.ucem.webapi.dao;

import java.util.List;
import ni.edu.ucem.webapi.modelo.Cupo;

public interface CupoDAO {
    public int contar();
    public List<Cupo> obtenerTodos(final int offset, final int limit);

    public void agregar(Cupo pcupo);

    public int contarPorCategoria(final int pCategoriaCuartoId);

    public List<Cupo> obtenerTodosPorCategoriaId(final int pCategoriaId, final int offset, final int limit);
}
