
package perceptron;

public class Main {

    public static void main(String[] args) {
        
        double[] peso;
        
        int A = 0;
        int B = 0;
        int saida;
        
        int[][] matrizAprendizado = new int[4][3];
        
        matrizAprendizado[0][0] = 0;
        matrizAprendizado[0][1] = 0;
        matrizAprendizado[0][2] = 0;
        
        matrizAprendizado[1][0] = 0;
        matrizAprendizado[1][1] = 1;
        matrizAprendizado[1][2] = 0;
        
        matrizAprendizado[2][0] = 1;
        matrizAprendizado[2][1] = 0;
        matrizAprendizado[2][2] = 0;
        
        matrizAprendizado[3][0] = 1;
        matrizAprendizado[3][1] = 1;
        matrizAprendizado[3][2] = 1;
        
        System.out.println("Matriz de Aprendizado");
        for (int[] matrizAprendizado1 : matrizAprendizado) {
            System.out.print("[ ");
            for (int j = 0; j < matrizAprendizado.length-1; j++) {
                System.out.print(matrizAprendizado1[j] + " ");
            }
            System.out.print("]\n");
        }
        
        Perceptron p = new Perceptron(matrizAprendizado);
        Perceptron p1 = new Perceptron(1, 1, 1);
        Perceptron p2 = new Perceptron(2, 1, 3);
        Perceptron p3 = new Perceptron(1, -2, 1);
        /*
        p.treinar();
        peso = p.getW();
        System.out.println("Epocas de treino percoridas: " + p.getCount());
        System.out.println("Pesos:"
                + "\nW0 = " + peso[0]
                + "\nW1 = " + peso[1]
                + "\nW2 = " + peso[2]);
        saida = p.executar(A, B);
        */
        saida = p3.executar(p1.executar(A, B), p2.executar(A, B));
        System.out.println(saida);
    }
    
}
