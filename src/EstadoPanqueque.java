import java.util.ArrayList;
import java.util.Arrays;

public class EstadoPanqueque implements Estado{
    
    private final int CANT_PANQ = 4;
    private int[] posicionActual;
    private final int[] META = {1,2,3,4};
    
    public EstadoPanqueque(int[] posiciones){
        posicionActual = posiciones;
    }
    
    @Override
    public boolean esMeta() {
        return Arrays.equals(posicionActual, META);
    }

    @Override
    public ArrayList<Estado> generarSucesores() {
        ArrayList<Estado> sucesores = new ArrayList<>();
        for(int i=2; i<=CANT_PANQ; i++){
            voltearPanqueques(i,sucesores);
        }
        return sucesores;
    }
    
    private void voltearPanqueques(int n, ArrayList<Estado> suc){
        int[] copia = crearCopia(posicionActual);
        int[] temp  = crearCopia(posicionActual);
        int i,j;
        for(i=n-1,j=0; i >= 0; i--,j++)
            temp[i] = copia[j];
        suc.add(new EstadoPanqueque(temp));
    }
    
    private int[] crearCopia(int[] estado){
        int[] resultado = new int[CANT_PANQ];
        System.arraycopy(estado, 0, resultado, 0, CANT_PANQ);
        return resultado;
    }

    @Override
    public void mostrarEstado() {
        System.out.println(posicionActual[0]+" | " + posicionActual[1]
            + " | " + posicionActual[2] + " | " + posicionActual[3]);
    }

    public int[] getPosicionActual(){
        return posicionActual;
    }
    
    @Override
    public boolean igual(Estado s) {
        return Arrays.equals(posicionActual,
                ((EstadoPanqueque)s).posicionActual);
    }
    
    public double costoCambio(EstadoPanqueque otro){
        int tam = this.getPosicionActual().length;
        double costoCambio = tam;
        for(int i=tam-1;i >= 1; i--){
            if(this.getPosicionActual()[i] == 
                    otro.getPosicionActual()[i]){
                costoCambio = costoCambio - 1;
            }
            else break;
        }
        return costoCambio;
    }
    
    public double calcularHeuristica(){
        int h = 0;
        for (int i = posicionActual.length-1; i >= 1; i--){
            if(posicionActual[i] != META[i]){
                h = META[i];
                break;
            }
        }
        return (double)h;
    }
    
}
