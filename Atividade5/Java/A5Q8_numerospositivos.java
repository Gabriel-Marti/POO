import java.util.Scanner;

public class A5Q8_numerospositivos {
    static Scanner Scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Insira o tamanho do array");
        int n = Scanner.nextInt(); //lendo quantos n numeros serao
        int[] Arraysalvo = MontarArray(n);

        int i;
        int acc = 0; //acc=acumuladora
        for(i=0 ; i<n ; i++ ) {
            //como o enunciado manda contar quantos são positivos, não estou considerando o nulo (0)
            if (Arraysalvo[i] > 0) {
                acc++;
            }
        }

        System.out.println("Nesse array, " +acc+ " elementos são positivos");

    }
    //um bom método para armazenar esse n números é montar um array
    static int[] MontarArray(int n) {
        
        
        int[] Array = new int[n];
        int i;
        System.out.println("Insira os elementos do array");
        for(i= 0 ; i < n ; i++) {
            Array[i] = Scanner.nextInt(); //lendo os n numeros
        }
        return Array;

    }
}
