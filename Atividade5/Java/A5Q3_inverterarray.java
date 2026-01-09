import java.util.Scanner;
import java.util.Arrays;

public class A5Q3_inverterarray {
    //metodo para montar o array
    static Scanner Scanner = new Scanner(System.in);
    
    static int[] MontarArray(int n) {
        System.out.println("Insira os elementos do array, para que sejam lidos");
        int[] listaNnumeros = new int[n];
        int i;
        for(i=0 ; i<n ; i++ ) {
            listaNnumeros[i] = Scanner.nextInt();
        }
        return listaNnumeros;
    }

    static int[] InverterArray(int n ,int[] lista) {
        int Variavelparacontrole = n - 1;
        int i;
        //nova lista é criada, essa será igual à lista original invertida após o loop
        //a "inversão" dessa nova lista é baseada na lista original
        int[] NovaLista = new int[n];
        for(i=0 ; i<n ; i++ ) {
            //o primeiro será o último e assim por diante, até que a lista seja completamente invertida
            NovaLista[i] = lista[Variavelparacontrole];
            Variavelparacontrole--;
        }
        return NovaLista;
    }
    public static void main(String[] args) {
        System.out.println("Insira o numero de elementos do array");
        int n = Scanner.nextInt();
        int[] array_original = MontarArray(n);
        System.out.print("Array original: ");
        System.out.println(Arrays.toString(array_original));
        System.out.print("Array invertido: ");
        System.out.println(Arrays.toString(InverterArray(n, array_original)));
    }
}
