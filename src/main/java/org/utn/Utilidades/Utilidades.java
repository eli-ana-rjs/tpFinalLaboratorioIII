package org.utn.Utilidades;

public class Utilidades {

    public static void dibujarRectanguloTexto(String texto) {
        int longitudTexto = texto.length();

// Dibujar el rectángulo
        dibujarRectangulo(longitudTexto);

// Imprimir el texto en el rectángulo
        System.out.println("| " + texto + " |");

// Dibujar el rectángulo nuevamente
        dibujarRectangulo(longitudTexto);
    }

    public static void dibujarRectangulo(int longitud) {
        for(int i = 0; i < longitud + 4; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Imprime linea de separacion
     */
    public static void imprimirLineas(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
