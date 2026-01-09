import java.util.Scanner;

public class A5Q4_posicoespares {
    static Scanner Scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Insira o numero de elementos no array");
        int n = Scanner.nextInt();
        int[] Arraysalvo = MontarArray(n);
        int i;
        //considerando as posições tradicionais do array, ou seja Array[0] = posição 0
        //assim a primeira posição seria par, por se tratar do 0 invés do 1, a contagem do computador
        //a segunda seria impar, por ser a posição 1, a terceira par por ser o 2 e assim por diante
        System.out.println("Imprimindo as posições pares:");
        for(i=0 ; i < n ; i++) {
            //um número par é todo inteiro divisível por 2
            //0 é divisível por qualquer número, então é considerado par
            if (i%2 == 0) {
                System.out.println(Arraysalvo[i]);
            }
        }
    }

    static int[] MontarArray(int n) {
        System.out.println("Insira os elementos do array");
        int i;
        int[] Array = new int[n];
        for(i=0 ; i <n ; i++) {
            Array[i] = Scanner.nextInt();
        }
        return Array;
    }
}
