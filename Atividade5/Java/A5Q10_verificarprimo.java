import java.util.Scanner;

public class A5Q10_verificarprimo {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        boolean Primo = VerificarPrimo(n);

        if ( Primo == true) {
            System.out.println("O número " + n + " é primo");
        } else { System.out.println("O número " + n + " não é primo"); }

    }

    static boolean VerificarPrimo(int n) {
        int acc=0; //acumuladora que vai servir para dar controle ao laço
        int i;
        //se ele for divisivel somente por 1 e ele mesmo ele é priumo
        //ou seja se o resto da divisão para todo numero de 2 até n for diferente de 
        //como se trata de inteiro da para considerar que o inicio parte de 2
        //e desconsiderar o proprio n uma vez que n sempre é divisível por n
        //assim da para eliminar os casos em que a divisão tem resto 0 para não botar as exceções
        //por serem inteiros, o sucessor de 1 sempre é 2(inicio) e o máximo menor que n é o antecessor
        for(i=2 ; i < n ; i++) {
            if (n % i == 0) {
                acc++;
            }
        }
        //mas ainda tem que considerar a exceção n = 1 ou n = 0, que não seria primo
        if (n == 1 || n ==0) {
            acc++;
        }
        if (acc == 0) {
            //se a acumuladora não foi incrementada então todas as divisões no laço tem resto não nulo
            return true; //ou seja n é primo
            //se não, alguma divisão resulta em resto nulo
        } else { return false ;} //ou seja, n não pode ser primo
        
    }

}
