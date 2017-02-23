package ni.edu.ucem.webapi;

import ni.edu.ucem.webapi.core.ApiResponse.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ni.edu.ucem.webapi.core.ApiResponse;

/*
 * La anotación @SpringBootApplication carga varias dependencias por defecto (tal como el contenedor de servlet 
 * envevido), activa el escaneo de componentes (@ComponentScan) y los EndPoints web (@EnableWebMvc), entre otras tareas.
 */
@SuppressWarnings("unused")
@SpringBootApplication
public class HotelWebApi
{
    private static final Logger log = LoggerFactory.getLogger(HotelWebApi.class);
    public static void main( String[] args )
    {
        /*
         * Con Maven or Gradle, es posible empaquetar la aplicación en formato WAR, sin embargo, para iniciar 
         * rapidamente la aplicación durante el desarrollo, implementamos una clase java ejecutable.
         */
        SpringApplication.run(HotelWebApi.class, args);
        ApiResponse.Status test = Status.BAD_REQUEST;
    }
}
