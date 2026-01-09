import java.lang.reflect.Array;
import java.util.Scanner;

public class A5Q12_menornumero {
    static Scanner Scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Insira quantos números serão considerados (tamanho do array)");
        int n = Scanner.nextInt(); //definindo o tamanho, lista com n números
        int[] Arraysalvo = MontarArray(n);
        int menor = Arraysalvo[0]; //será o menor valor, variável conforme for iterando
        int i;
        //como o menor já é primeiro elemento (Array[0]) por padrão
        //  pode pular direto pro 1 e ignorar o primeiro(0)
        for(i = 1 ; i < n ; i++) {
            if (Arraysalvo[i] < menor) {
                menor = Arraysalvo[i];
            }
        }
        System.out.println("O menor número é " + menor);
    }

    static int[] MontarArray(int n) {
        int[] Array = new int[n];
        System.out.println("Insira os números");
        int i;
        for(i = 0 ; i < n ; i++) {
            Array[i] = Scanner.nextInt();
        }
        return Array;
    }
}
