package ejemplo01;

import java.util.List;

import ejemplo00.Empleado;
import ejemplo00.Tarea;
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
@Path("/gerente")
public class GerenteApi {

	@Inject
	private EmpleadoServiceImp servicio;
	
	/*
	 * curl --user usr2:123 -X GET http://localhost:8080/Empleados-JakartaEE-RESTful/api/gerente/1/tareas
	 */
	@GET
    @Path("/{id}/tareas")
	@RolesAllowed("gerente")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarea> listarTareasEmpleado(@PathParam("id") int idEmpleado) {
        System.out.println("Listando tareas del empleado " + idEmpleado);
        return servicio.listarTareasEmpleado(idEmpleado);
    }
	
	
	/**
	 * curl -v --user usr2:123 http://localhost:8080/Empleados-JakartaEE-RESTful/api/gerente
	 * @return
	 */
	@GET
	@RolesAllowed("gerente")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empleado> obtenerEmpleados() {
		System.out.println("Retornando todos los empleados");
		return servicio.listarEmpleados();
	}


}