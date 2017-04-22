
package perceptron;

import static java.lang.System.in;
import java.util.Scanner;

public class Exemplo1 {

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(in);
        double[] peso;
        
        int A, B;
        int saida;
        
        int[][] matrizAprendizadoAND = new int[4][3];
        int[][] matrizAprendizadoOR = new int[4][3];

        // Inicialização da matriz de treinamento AND
        matrizAprendizadoAND[0][0] = 0;
        matrizAprendizadoAND[0][1] = 0;
        matrizAprendizadoAND[0][2] = 0;
        
        matrizAprendizadoAND[1][0] = 0;
        matrizAprendizadoAND[1][1] = 1;
        matrizAprendizadoAND[1][2] = 0;
        
        matrizAprendizadoAND[2][0] = 1;
        matrizAprendizadoAND[2][1] = 0;
        matrizAprendizadoAND[2][2] = 0;
        
        matrizAprendizadoAND[3][0] = 1;
        matrizAprendizadoAND[3][1] = 1;
        matrizAprendizadoAND[3][2] = 1;
        
        // Inicialização da matriz de treinamento OR
        matrizAprendizadoOR[0][0] = 0;
        matrizAprendizadoOR[0][1] = 0;
        matrizAprendizadoOR[0][2] = 0;
        
        matrizAprendizadoOR[1][0] = 0;
        matrizAprendizadoOR[1][1] = 1;
        matrizAprendizadoOR[1][2] = 1;
        
        matrizAprendizadoOR[2][0] = 1;
        matrizAprendizadoOR[2][1] = 0;
        matrizAprendizadoOR[2][2] = 1;
        
        matrizAprendizadoOR[3][0] = 1;
        matrizAprendizadoOR[3][1] = 1;
        matrizAprendizadoOR[3][2] = 1;
        
        Perceptron p = new Perceptron(matrizAprendizadoOR);
        
        p.treinar();
        peso = p.getW();
        
        System.out.println("Epocas de treino percoridas: " + p.getCount());
        System.out.println("Pesos:"
                + "\nW0 = " + peso[0]
                + "\nW1 = " + peso[1]
                + "\nW2 = " + peso[2]);
        
        while(true){
            System.out.println("\nPrimeira entrada: ");
            A = ler.nextInt();
            System.out.println("Segunda entrada: ");
            B = ler.nextInt();
            saida = p.executar(A, B);
            System.out.println("Saida: " + saida);
        }
    }
}
