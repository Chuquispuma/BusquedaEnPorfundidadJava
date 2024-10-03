# BusquedaEnPorfundidadJava - BusquedaAEstrella

Correcciones del SonarLint

## Caso 1: Uso de System.out en lugar de un Logger
**Violación:** Replace this use of System.out by a logger.sonarlint(java:S106)

*Descripción:* El uso de System.out para imprimir en la consola no es una buena práctica, ya que no es flexible ni escalable. Se recomienda utilizar un sistema de logging.

**Corrección:** Reemplazar System.out con un logger.

**Fragmento de Código:**
```Java
import java.util.logging.Logger;

public class BusquedaAEstrella {

    private static final Logger logger = Logger.getLogger(BusquedaAEstrella.class.getName());

    public static void main(String[] args) {
        logger.info("Sale de la cola: ");
    }
}
```
## Caso 2: Cast innecesario
**Violación:** Unnecessary cast (sonarlint(java:S1905))

*Descripción:* SonarLint detectó que el código contiene un cast innecesario, lo que aumenta la complejidad sin proporcionar ningún beneficio.

**Corrección:** Eliminar el cast innecesario, ya que el método eliminarAlInicio() devuelve el tipo adecuado.

**Fragmento de Código:**
```Java
NodoDeBusquedaF nodoTemp = cola.eliminarAlInicio();
```

## Caso 3: Reemplazo de clase sincronizada Stack
**Violación:** Replace synchronized class Stack by unsynchronized class (sonarlint(java:S1149))

*Descripción:* El uso de la clase Stack está desaconsejado porque está sincronizada, lo que puede afectar al rendimiento si no se necesita sincronización. Se sugiere usar una clase no sincronizada, como Deque, para manejar las operaciones LIFO (Last In, First Out).

**Corrección:** Reemplazar Stack por Deque para mejorar la eficiencia.

**Fragmento de Código:**
```Java
Deque<NodoDeBusquedaF> caminoSolucion = new ArrayDeque<>();
caminoSolucion.push(nodoTemp);
```

## Caso 4: Código comentado innecesario
**Violación:** This block of commented-out lines of code should be removed.sonarlint(java:S125)

*Descripción:* El código comentado sin utilidad aumenta el ruido en el código y puede volverse obsoleto con el tiempo, haciéndolo difícil de mantener.

**Corrección:** Eliminar las líneas comentadas y recurrir al control de versiones para recuperarlas si es necesario.
