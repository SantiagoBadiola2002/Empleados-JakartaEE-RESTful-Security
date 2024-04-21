package ejemplo00.aplicacion;

import java.util.List;

import ejemplo00.Empleado;
import ejemplo00.Tarea;

public interface EmpleadoService {

	public void agregarEmpleado(Empleado empleado);

	public void eliminarEmpleado(int id);

	public List<Empleado> listarEmpleados();

	public Empleado obtenerInformacionEmpleado(int id);

	public void agregarTareaAEmpleado(int idEmpleado, Tarea tarea);

	public List<Tarea> listarTareasEmpleado(int id);
}
