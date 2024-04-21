package ejemplo01;

import java.util.List;

import ejemplo00.Empleado;
import ejemplo00.Tarea;
import ejemplo00.aplicacion.impl.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@ApplicationScoped
@Path("/empleados")
public class EmpleadoRESTful {
	
	@Inject
	private EmpleadoServiceImp empleadoService;
	
	/**
	 * curl -X POST http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes 
	 * -H "Content-Type: application/json" 
	 * -d '{"id":3,"nombre":"Marta"}'
	 * @param empl
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //tenemos que indicar como viene formateada la información
	@Produces({MediaType.APPLICATION_JSON})
	public void agregarEmpleado(Empleado empl) {
		System.out.println("Nuevo empleado:" + empl);
		
		empleadoService.agregarEmpleado(empl);
	}
	
	
	
	/**
	 * curl  -X "DELETE" http://localhost:8080/Empleados-JakartaEE-RESTful/api/empleados/1
	 * 
	 * @param id
	 */
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public void borrarEmpleado(@PathParam("id") int id) {
		System.out.println("Invocando borrarEmpleado con id:" + id);
		
		empleadoService.eliminarEmpleado(id);
	}
	
	/**
	 * curl -v http://localhost:8080/Empleados-JakartaEE-RESTful/api/empleados/1
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Empleado obtenerEmpleado(@PathParam("id") int id) { //observar la anotación @PathParam
		System.out.println("Invocando obtenerCliente con id:" + id);
		
		return empleadoService.obtenerInformacionEmpleado(id);
	}
	
	
	/**
	 * curl -v http://localhost:8080/Empleados-JakartaEE-RESTful/api/empleados
	 * @return
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empleado> obtenerEmpleados() {
		System.out.println("Retornando todos los empleados");
		return empleadoService.listarEmpleados();
	}
	
	/*
	 * curl -X PUT \
    http://localhost:8080/Empleados-JakartaEE-RESTful/api/empleados/1 \
    -H "Content-Type: application/json" \
    -d '{
        "id": 1,
        "descripcion": "Tarea de prueba",
        "fechaInicio": "2024-04-15",
        "fechaFin": "2024-04-16"
    }'

	 */
	@PUT
	@Path("/{idEmpleado}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void agregarTareaAEmpleado(@PathParam("idEmpleado") int idEmpleado, Tarea tarea) {
	    System.out.println("Agregando tarea " + tarea.getId() + " al empleado " + idEmpleado);
	    empleadoService.agregarTareaAEmpleado(idEmpleado, tarea);
	}
	
	/*
	 * curl -X GET "http://localhost:8080/Empleados-JakartaEE-RESTful/api/empleados/1/tareas"
	 */
	@GET
    @Path("/{id}/tareas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarea> listarTareasEmpleado(@PathParam("id") int idEmpleado) {
        System.out.println("Listando tareas del empleado " + idEmpleado);
        return empleadoService.listarTareasEmpleado(idEmpleado);
    }

	

}
