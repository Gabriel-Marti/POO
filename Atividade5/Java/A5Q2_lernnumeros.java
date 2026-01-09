import java.util.Scanner;
import java.util.Arrays;

public class A5Q2_lernnumeros {
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(lerNnumeros()));
        

    }

    // Como o enunciado pediu um método, fiz um método separado do main.
    static int[] lerNnumeros() {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();

        
        int[] listaNnumeros = new int[n];

        //pelo enunciado, da a entender que basta ler quaisquer n numeros
        // Para simplificar serão numeros em ordem crescente mesmo
        int i;
        //partindo da posição 0 até a posição n serão n+1 elementos
        //de 0 até n-1, ou seja a condição em que i<n serão n elementos
        for(i=0; i < n ; i++ ) {
            //para que o método leia é preciso que algo seja inserido, ou seja o usuario vai inserir
            listaNnumeros[i] = Scanner.nextInt();
        }

        
        return listaNnumeros;

    }
}
