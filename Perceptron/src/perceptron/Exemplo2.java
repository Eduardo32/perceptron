
package perceptron;

import static java.lang.System.in;
import java.util.Scanner;

public class Exemplo2 {
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(in);
        double[] peso1;
        double[] peso2;
        double[] peso3;
        
        int A, B;
        int saida;
        
        int[][] matrizAprendizado1 = new int[4][3];
        int[][] matrizAprendizado2 = new int[4][3];
        int[][] matrizAprendizado3 = new int[4][3];

        // Inicialização da matriz de treinamento 1
        matrizAprendizado1[0][0] = 0;
        matrizAprendizado1[0][1] = 0;
        matrizAprendizado1[0][2] = 0;
        
        matrizAprendizado1[1][0] = 0;
        matrizAprendizado1[1][1] = 1;
        matrizAprendizado1[1][2] = 1;
        
        matrizAprendizado1[2][0] = 1;
        matrizAprendizado1[2][1] = 0;
        matrizAprendizado1[2][2] = 1;
        
        matrizAprendizado1[3][0] = 1;
        matrizAprendizado1[3][1] = 1;
        matrizAprendizado1[3][2] = 1;
        
        // Inicialização da matriz de treinamento 2
        matrizAprendizado2[0][0] = 0;
        matrizAprendizado2[0][1] = 0;
        matrizAprendizado2[0][2] = 0;
        
        matrizAprendizado2[1][0] = 0;
        matrizAprendizado2[1][1] = 1;
        matrizAprendizado2[1][2] = 0;
        
        matrizAprendizado2[2][0] = 1;
        matrizAprendizado2[2][1] = 0;
        matrizAprendizado2[2][2] = 0;
        
        matrizAprendizado2[3][0] = 1;
        matrizAprendizado2[3][1] = 1;
        matrizAprendizado2[3][2] = 1;
        
        // Inicialização da matriz de treinamento 3
        matrizAprendizado3[0][0] = 0;
        matrizAprendizado3[0][1] = 0;
        matrizAprendizado3[0][2] = 0;
        
        matrizAprendizado3[1][0] = 1;
        matrizAprendizado3[1][1] = 0;
        matrizAprendizado3[1][2] = 1;
        
        matrizAprendizado3[2][0] = 1;
        matrizAprendizado3[2][1] = 0;
        matrizAprendizado3[2][2] = 1;
        
        matrizAprendizado3[3][0] = 1;
        matrizAprendizado3[3][1] = 1;
        matrizAprendizado3[3][2] = 0;
        
        Perceptron p1 = new Perceptron(matrizAprendizado1);
        Perceptron p2 = new Perceptron(matrizAprendizado2);
        Perceptron p3 = new Perceptron(matrizAprendizado3);
        
        p1.treinar();
        peso1 = p1.getW();
        p2.treinar();
        peso2 = p2.getW();
        p3.treinar();
        peso3 = p3.getW();
        
        System.out.println("\nEpocas de treino percoridas para o perceptron 1: " + p1.getCount());
        System.out.println("Pesos:"
                + "\nW0 = " + peso1[0]
                + "\nW1 = " + peso1[1]
                + "\nW2 = " + peso1[2]);
        
        System.out.println("\nEpocas de treino percoridas para o perceptron 2: " + p2.getCount());
        System.out.println("Pesos:"
                + "\nW0 = " + peso2[0]
                + "\nW1 = " + peso2[1]
                + "\nW2 = " + peso2[2]);
        
        System.out.println("\nEpocas de treino percoridas para o perceptron 3: " + p3.getCount());
        System.out.println("Pesos:"
                + "\nW0 = " + peso3[0]
                + "\nW1 = " + peso3[1]
                + "\nW2 = " + peso3[2]);
        
        while(true){
            System.out.println("\nPrimeira entrada: ");
            A = ler.nextInt();
            System.out.println("Segunda entrada: ");
            B = ler.nextInt();
            saida = p3.executar(p1.executar(A, B), p2.executar(A, B));
            System.out.println("Saida: " + saida);
        }
    }
}
