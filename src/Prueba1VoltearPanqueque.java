
import java.util.ArrayList;

public class Prueba1VoltearPanqueque {
    public static void main(String[] args) {
        int[] a = {3,4,2,1};
        int[] b = {2,1,3,4};
        EstadoPanqueque p1 = new EstadoPanqueque(a);
        EstadoPanqueque p2 = new EstadoPanqueque(b);

        p1.mostrarEstado();
        ArrayList<Estado> suc = new ArrayList<Estado>();
        suc = p1.generarSucesores();
//        p1.voltearPanqueques(2, suc);
//        p1.voltearPanqueques(3, suc);
        for(Estado e: suc){
            ((EstadoPanqueque)e).mostrarEstado();
        }
        double c1 = p1.costoCambio((EstadoPanqueque)suc.get(0));
        System.out.println(c1);
        double c2 = p1.costoCambio((EstadoPanqueque)suc.get(1));
        System.out.println(c2);
        /*2 | 3 | 1 p1
          3 | 2 | 1 suc(0)
          1 | 3 | 2 suc(1)*/
        System.out.println(p1.calcularHeuristica());
        System.out.println(p2.calcularHeuristica());
        
    }
}
