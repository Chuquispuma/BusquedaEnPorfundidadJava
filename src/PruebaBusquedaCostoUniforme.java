public class PruebaBusquedaCostoUniforme {
    public static void main(String[] args) {
        int[] a = {1,3,4,2};
        EstadoPanqueque inicio = new EstadoPanqueque(a);
        NodoDeBusquedaC raiz = new NodoDeBusquedaC(inicio);
        BusquedaCostoUniforme.buscar(raiz, true);
    }
    
}
