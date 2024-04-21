package ejemplo00.aplicacion.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ejemplo00.Empleado;
import ejemplo00.Tarea;
import ejemplo00.aplicacion.EmpleadoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmpleadoServiceImp implements EmpleadoService{
	List<Empleado> empleados; 
	
	@PostConstruct
	private void inicializar() {
		System.out.println("Invocando PostConstruct");
		this.empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado(1,"Luis", "Empl123"));
		empleados.add(new Empleado(2,"Maria", "Empl456"));
		empleados.add(new Empleado(3,"Pablo", "Empl789"));
	}

	@Override
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
		
	}

	@Override
	public void eliminarEmpleado(int id) {
		Empleado emp = obtenerInformacionEmpleado(id);
		empleados.remove(emp);
		
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return empleados;
	}

	@Override
	public Empleado obtenerInformacionEmpleado(int id) {
	    for (Empleado empleado : empleados) {
	        if (empleado.getId() == id) {
	            return empleado;
	        }
	    }
	    return null; 
	}

	@Override
	public void agregarTareaAEmpleado(int idEmpleado, Tarea tarea) {
	    Empleado empleado = obtenerInformacionEmpleado(idEmpleado);
	    if (empleado != null) {
	        empleado.agregarTarea(tarea); 
	    }
	}

	@Override
	public List<Tarea> listarTareasEmpleado(int id) {
	    Empleado empleado = obtenerInformacionEmpleado(id);
	    if (empleado != null) {
	        return empleado.getTareas(); 
	    }
	    return Collections.emptyList(); 
	}


}
