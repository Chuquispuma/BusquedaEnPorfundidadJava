public class PruebaListaOrdenada {
    public static void main(String[] args) {
           ListaOrdenadaSE<Integer> cola = 
                   new ListaOrdenadaSE<Integer>();
           cola.insertar(7);
           cola.insertar(8);
           cola.insertar(3);
           cola.insertar(9);
           cola.insertar(2);
           cola.insertar(7);
           for(Integer x : cola){
               System.out.println(cola.eliminarAlInicio());
           }
    }
    
}
