
package ni.edu.ucem.webapi.daoImpl;

import java.util.List;
import ni.edu.ucem.webapi.dao.CupoDAO;
import ni.edu.ucem.webapi.modelo.Cupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CupoDAOImpl implements CupoDAO 
{
    
  private final JdbcTemplate jdbcTemplate;
   
  @Autowired
  public CupoDAOImpl(final JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }
  
    public Cupo obtenerPorId(final int pId) 
    {
        String sql = "select * from cupo where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{pId}, 
                new BeanPropertyRowMapper<Cupo>(Cupo.class));
    }

    @Override
    public List<Cupo> obtenerTodos(final int pOffset, final int pLimit) {
      String sql = "select * from cupo offset ? limit ?";
        return this.jdbcTemplate.query(sql, new Object[]{pOffset, pLimit},
        new BeanPropertyRowMapper<Cupo>(Cupo.class));
    }
    
    @Override
    public int contar()
    {
        final String sql = "select count(*) from cupo";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }
    
    @Override
    public int contarPorCategoria(final int categoriaId)
    {
        final String sql = "select count(*) from cupo";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }
    
    @Override
    public List<Cupo> obtenerTodosPorCategoriaId(int pCategoriaId, int pOffset, int pLimit) 
    {
        final String sql = "select * from cupo where categoria = ? offset ? limit ?";
        return this.jdbcTemplate.query(sql, new Object[]{pCategoriaId, pOffset, pLimit},
                new BeanPropertyRowMapper<Cupo>(Cupo.class));
    }
    
    @Override
    public void agregar(final Cupo pCupo) 
    {
        final String sql = new StringBuilder()
                .append("INSERT INTO cupo")
                .append(" ")
                .append("(fecha_ingreso, fecha_salida, categoria)")
                .append(" ")
                .append("VALUES(?,?,?)")
                .toString();
        final Object[] parametros = new Object[3];
        parametros[0] = pCupo.getFechaIngreso();
        parametros[1] = pCupo.getFechaSalida();
        parametros[2] = pCupo.getCategoria();
        this.jdbcTemplate.update(sql,parametros);
    }
}
