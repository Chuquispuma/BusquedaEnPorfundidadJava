import java.util.ArrayList;


public interface Estado
{
	// determina si el estado actual es una meta
	boolean esMeta();

	// generar sucesores para el estado actual
	ArrayList<Estado> generarSucesores();

	// mostrar el estado actual
	public void mostrarEstado();

	// comparar los datos del estado actual
	public boolean igual(Estado s);
}
