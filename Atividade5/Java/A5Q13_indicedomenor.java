import java.util.Scanner;

public class A5Q13_indicedomenor {
    static Scanner Scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Escreva quantos números serão comparados");
        int n = Scanner.nextInt();
        int[] Arraysalvo = MontarArray(n);
        int menorNumero = Arraysalvo[0];
        int indice_do_menor = 0; //pois o menor foi definido por padrão como o primeiro 
        int i;
        //começar do 1, pelo mesmo motivo da questão anterior
        for(i=1 ; i < n ; i++) {
            if (Arraysalvo[i] < menorNumero) {
                menorNumero = Arraysalvo[i];
                indice_do_menor = i;
            }
        }
        System.out.println("O indíce do menor número no array é " + indice_do_menor);
    }

    static int[] MontarArray(int n) {
        int[] Array = new int[n];
        System.out.println("Insira os números");
        int i;
        for(i=0 ; i < n ; i++){
            Array[i] = Scanner.nextInt();
        }
        return Array;
    }
}
