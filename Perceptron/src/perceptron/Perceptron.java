
package perceptron;

public class Perceptron {

    // Arranjo para guardar os pesos: [0] entrada 1, [1] entrada 2, [3]BIAS
    private final double[] w = new double[3];

    // Variável responsável pelo somatório(rede).
    private double NET = 0;

    // Variavél responsável pelo número máximo de épocas
    private final int epocasMax = 30;

    // Variável responsável pela contagem das épocas durante o treinamento
    private int count = 0;

    // Declara o vetor da matriz de aprendizado
    private int[][] matrizAprendizado = new int[4][3];

    // MÉTODO DE RETORNO DO CONTADOR
    public int getCount(){
        return this.count;
    }
    
    // Método de retorno dos pesos
    public double[] getW() {
        return w;
    }
    
    // metodo de inicialização dos pesos
    public Perceptron(double w0, double w1, double w2) {
        
        w[0] = w0;
        // Peso sináptico para segunda entrada.
        w[1] = w1;
        // Peso sináptico para o BIAS
        w[2]= w2;
    }
    
    // metodo de inicialização inicia o vetor da matriz de aprendizado
    public Perceptron(int[][] matrizAprendizado){
        this.matrizAprendizado = matrizAprendizado;

        // Peso sináptico para primeira entrada.
        w[0] = 0;
        // Peso sináptico para segunda entrada.
        w[1] = 0;
        // Peso sináptico para o BIAS
        w[2]= 0;
    }

    // Método responsávelpelo somatório e a função de ativação.
    public int executar(int x1, int x2) {

        // Somatório (NET)
        NET = (x1 * w[0]) + (x2 * w[1]) + ((-1) * w[2]);

        // Função de Ativação
        if (NET >= 0) {
            return 1;
        }
        return 0;
    }

    // Método para treinamento da rede
    public void treinar() {
        // variavel utilizada responsável pelo controlede treinamento recebefalso
        boolean treinou= true;
        // varável responsável para receber o valor da saída (y)
        int saida;

        // laço usado para fazer todas as entradas
        for (int i = 0; i < matrizAprendizado.length; i++) {
            // A saída recebe o resultado da rede que no caso é 1 ou 0
            saida = executar(matrizAprendizado[i][0], matrizAprendizado[i][1]);
            
           
            if (saida != matrizAprendizado[i][2]) {
                // Caso a saída seja diferente do valor esperado
                
                // os pesos sinápticos serão corrigidos
                corrigirPeso(i, saida);
                // a variavél responsável pelo controlede treinamento recebe falso
                treinou = false;

            }
        }
        // acrescenta uma época
        this.count++;

        // teste se houve algum erro duranteo treinamento e o número de epocas
        //é menor qe o definido
        if((treinou == false) && (this.count < this.epocasMax)) {
            // chamada recursiva do método
            treinar();

        }
    }// fim do método para treinamento

    // Método para a correção de pesos
    public void corrigirPeso(int i, int saida) {

        w[0] = w[0] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][0]);
        w[1] = w[1] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][1]);
        w[2] = w[2] + (1 * (matrizAprendizado[i][2] - saida) * (-1));
    }
}
