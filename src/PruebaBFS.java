public class PruebaBFS {
    public static void main(String[] args) {
        int[] a = {3,4,2,1};; 
        EstadoPanqueque inicio = new EstadoPanqueque(a);
        NodoDeBusqueda raiz = new NodoDeBusqueda(inicio);
        BusquedaBFS.buscar(raiz, true);
        
    }
}
