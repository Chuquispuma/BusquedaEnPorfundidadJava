import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Deque;
import java.util.logging.Logger;

public class BusquedaAEstrella {

    private static final Logger logger = Logger.getLogger(BusquedaAEstrella.class.getName());
    public static void buscar(NodoDeBusquedaF raiz, boolean d)
    {
        ListaOrdenadaSE<NodoDeBusquedaF> cola = new ListaOrdenadaSE<NodoDeBusquedaF>();
        cola.insertar(raiz);
        realizarBusqueda(cola, d);
    }

    /*
     * Método de ayuda para revisar si un NodoDeBusqueda ya fue evaluado.
     * Returns true si ya fue evaluado, false en caso contrario.
     */
    private static boolean revisarRepetidos(NodoDeBusquedaF n)
    {
        boolean resultado = false;
        NodoDeBusquedaF nodoRevisado = n;

        // Mientras el padre de n no sea nulo, revisar si es igual al nodo
        // que estamos buscando.
        while (n.getPadre() != null && !resultado)
        {
            if (n.getPadre().getEstadoActual().igual(nodoRevisado.getEstadoActual()))
            {
                resultado = true;
            }
            n = n.getPadre();
        }

        return resultado;
    }

    /**
     * Realiza la Busqueda BFS usando la cola como el espacio a buscar
     */
    public static void realizarBusqueda(ListaOrdenadaSE<NodoDeBusquedaF> cola, boolean d)
    {
        int contadorBusqueda = 1; // contador para el número de iteraciones

        while (!cola.estaVacia()) // mientras la cola no este vacía
        {
            logger.info("Sale de la cola: ");
            NodoDeBusquedaF nodoTemp = cola.eliminarAlInicio();
            logger.info(" (f = " + nodoTemp.getF()+") ");
            nodoTemp.getEstadoActual().mostrarEstado();
            // si el nodoTemp no es el estado meta
            if (!nodoTemp.getEstadoActual().esMeta())
            {
                //costo acumulado del padre
                double costoAcumPadre = nodoTemp.getCosto();
                
                // generar los sucesores inmediatos a nodoTemp
                ArrayList<Estado> sucesoresTemp = nodoTemp.getEstadoActual()
                                .generarSucesores();

                /*
                 * Iterar a través de los sucesores, envolverlo en un 
                 * NodoDeBusqueda, revisar si ya fue evaluado, y si no
                 * agregarlo a la cola.
                 */
                for (int i = 0; i < sucesoresTemp.size(); i++)
                {
                    // segundo parametro que suma el costo del nuevo nodo al 
                    // costo total actual en el NodoDeBusqueda
                    double costoCambio = 0;
                    costoCambio = ((EstadoPanqueque)nodoTemp.getEstadoActual()).
                        costoCambio((EstadoPanqueque)sucesoresTemp.get(i));
                    
                    double costoAcumSucesor = costoAcumPadre + costoCambio;
                    
                    //heurística 
                    double h = 
                            ((EstadoPanqueque)sucesoresTemp.get(i)).
                                    calcularHeuristica();                    
                    
                    NodoDeBusquedaF nuevoNodo = new NodoDeBusquedaF(nodoTemp,
                        sucesoresTemp.get(i),costoAcumSucesor,h);

                    if (!revisarRepetidos(nuevoNodo))
                    {
                            cola.insertar(nuevoNodo);
                    }
                }
                contadorBusqueda++;
            }
            else
            // El estado meta se encontro. Imprimir el camino que lleva a este
            {
                // Use una pila para seguir el camino desde el estado inicial
                // al estado meta
                Deque<NodoDeBusquedaF> caminoSolucion = new ArrayDeque<>();
                caminoSolucion.push(nodoTemp);
                nodoTemp = nodoTemp.getPadre();

                while (nodoTemp.getPadre() != null)
                {
                    caminoSolucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getPadre();
                }
                caminoSolucion.push(nodoTemp);

                // El tamaño de la pila antes de iterarla y vaciarla.
                int iteraciones = caminoSolucion.size();

                for (int i = 0; i < iteraciones; i++)
                {
                    nodoTemp = caminoSolucion.pop();
                    nodoTemp.getEstadoActual().mostrarEstado();
                    logger.info("");
                    logger.info("");
                }
                if (d)
                {
                    logger.fine("El número de nodos examinados: " + contadorBusqueda);
                }

                System.exit(0);
            }
        }

        // No debería ocurrir nunca.
        logger.info("Error! Solución no encontrada!");
    } 
}

