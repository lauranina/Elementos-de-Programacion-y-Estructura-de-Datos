import java.util.Arrays;

public class Ejercicio2{
    
   public boolean puedoGenerar(String[] a, String x) {
        return puedoGenerarAux(a, x, 0);
    }
    
    private boolean puedoGenerarAux(String[] a, String x, int index) {
        // Si ya hemos llegado al final de la cadena x, retornamos true
        if (index == x.length()) return true;
        
        // Verificamos si es posible formar el número
        for (int i = index; i < x.length(); i++) {
            String prefijo = x.substring(index, i + 1);
            if (Arrays.asList(a).contains(prefijo)) {
                // Si encontramos un prefijo en a, intentamos formar el resto del número recursivamente
                if (puedoGenerarAux(a, x, i + 1)) return true;
            }
        }
        
        // Si no encontramos ninguna combinación válida, retornamos false
        return false;
    }
} 