public class PruebaBusquedaAEstrella {
    public static void main(String[] args) {
        int[] a = {3,4,2,1};
        EstadoPanqueque inicio = new EstadoPanqueque(a);
        NodoDeBusquedaF raiz = 
                new NodoDeBusquedaF(inicio,inicio.calcularHeuristica());
        BusquedaAEstrella.buscar(raiz, true);        
    }
}

