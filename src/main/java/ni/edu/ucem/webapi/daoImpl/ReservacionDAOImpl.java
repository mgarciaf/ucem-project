
package ni.edu.ucem.webapi.daoImpl;

import ni.edu.ucem.webapi.dao.ReservacionDAO;
import ni.edu.ucem.webapi.modelo.Reservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservacionDAOImpl implements ReservacionDAO {
    
  private final JdbcTemplate jdbcTemplate;
   
  @Autowired
  public ReservacionDAOImpl(final JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }
  
    public Reservacion obtenerPorId(final int pId) 
    {
        String sql = "select * from reservacion where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{pId}, 
                new BeanPropertyRowMapper<Reservacion>(Reservacion.class));
    }
    
    @Override
    public void agregar(final Reservacion pReservacion) 
    {
        final String sql = new StringBuilder()
                .append("INSERT INTO reservacion")
                .append(" ")
                .append("(desde, hasta, cuarto, huesped)")
                .append(" ")
                .append("VALUES(?,?,?)")
                .toString();
        final Object[] parametros = new Object[4];
        parametros[0] = pReservacion.getDesde();
        parametros[1] = pReservacion.getHasta();
        parametros[2] = pReservacion.getCuarto();
        parametros[3] = pReservacion.getHuesped();
        this.jdbcTemplate.update(sql,parametros);
    }
    
}