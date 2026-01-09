import java.util.Scanner;

public class A5Q11_acimadamedia {
    static Scanner Scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Insira quantos elementos terá o array");
        int n = Scanner.nextInt();
        int[] Arraysalvo = MontarArray(n);

        int acc = 0; //acumuladora
        int i;
        for(i=0 ; i < n ; i++) {
            acc += Arraysalvo[i];
        }
        int media = acc/n;

        acc = 0; //resetando a acumuladora e o i para novo laço
        for (i = 0 ; i < n ; i++) {
            if (Arraysalvo[i] > media) {
                acc++;
            }
        }
        
        System.out.println(acc + " números estão acima da média");
        
    }

    static int[] MontarArray(int n) {
        System.out.println("Insira os elementos do array");
        int[] Array = new int[n];
        int i;
        for (i=0 ; i<n ; i++) {
            Array[i] = Scanner.nextInt();

        }
        return Array;
    }
}
