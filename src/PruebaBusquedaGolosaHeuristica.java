public class PruebaBusquedaGolosaHeuristica {
    public static void main(String[] args) {
        int[] a = {3,4,2,1};
        EstadoPanqueque inicio = new EstadoPanqueque(a);
        NodoDeBusquedaH raiz = 
                new NodoDeBusquedaH(inicio,inicio.calcularHeuristica());
        BusquedaGolosaH.buscar(raiz, true);
    }
}
