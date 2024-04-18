public class Ejercicio1{
    
    public boolean puedoSalir(int n, String[] maze) {
        char[][] laberinto = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            laberinto[i] = maze[i].toCharArray();
        }
        
        // Encontrar la posición inicial (S)
        int startX = -1, startY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (laberinto[i][j] == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
            if (startX != -1) break;
        }
        
        // Llamamos a la función auxiliar para encontrar si es posible salir
        return puedeSalir(laberinto, startX, startY);
    }
    
    // Función auxiliar
    private boolean puedeSalir(char[][] laberinto, int x, int y) {
        int n = laberinto.length;
        
        // Si la posición actual es la salida (E), retorna true
        if (laberinto[x][y] == 'E') return true;
        
        // Marcamos la posición actual como visitada
        laberinto[x][y] = 'X';
        
        // Verificamos movimientos en las cuatro direcciones
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            // Verificar si la nueva posición es válida y no es una pared
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && laberinto[newX][newY] != '?' && laberinto[newX][newY] != 'X') {
                if (puedeSalir(laberinto, newX, newY)) return true;
            }
        }
        
        // Si no se encontro una salida en ninguna dirección, retrocede
        laberinto[x][y] = '.';
        return false;
    }
}   
