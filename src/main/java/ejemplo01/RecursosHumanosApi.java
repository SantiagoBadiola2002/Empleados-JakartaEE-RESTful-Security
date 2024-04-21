package ejemplo01;

import ejemplo00.Empleado;
import ejemplo00.aplicacion.impl.EmpleadoServiceImp;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/recursosHumanos")
public class RecursosHumanosApi {

	@Inject
	private EmpleadoServiceImp servicio;
	
	// curl -v http://localhost:8080/Empleados-JakartaEE-RESTful/api/recursosHumanos/agregarEmpleado
	// curl --user usr1:123 -v http://localhost:8080/Empleados-JakartaEE-RESTful/api/recursosHumanos/agregarEmpleado 
	@POST
	@Path("/agregarEmpleado")
	@RolesAllowed("recursosHumanos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void agregarEmpleado(Empleado empl) {
		System.out.println("Nuevo empleado:" + empl);
		
		servicio.agregarEmpleado(empl);
	}
	
	
	// curl --user usr1:123 -X DELETE http://localhost:8080/Empleados-JakartaEE-RESTful/api/recursosHumanos/borrarEmpleado/3
	@DELETE
	@Path("/borrarEmpleado/{id}")
	@RolesAllowed("recursosHumanos")
	@Produces({MediaType.APPLICATION_JSON})
	public void borrarEmpleado(@PathParam("id") int id) {
		System.out.println("Invocando borrarEmpleado con id:" + id);
		servicio.eliminarEmpleado(id);
	}

	

}