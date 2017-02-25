
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
}
