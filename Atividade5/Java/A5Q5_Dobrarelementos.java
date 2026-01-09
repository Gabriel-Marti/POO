import java.util.Scanner;
import java.util.Arrays;

public class A5Q5_Dobrarelementos {
    static Scanner Scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Insira o tamanho do Array");
        int TamanhoArray = Scanner.nextInt();
        int[] Arraysalvo = MontarArray(TamanhoArray);
        System.out.print("Array original: ");
        System.out.println(Arrays.toString(Arraysalvo));
        System.out.print("Array dobrado ");
        DobrarElementosDoArray(Arraysalvo, TamanhoArray);
        System.out.println(Arrays.toString(Arraysalvo));

    }

    //o método em questão, pega determinado array e dobra ele, modificando o array original
    static void DobrarElementosDoArray(int[] Array, int TamanhoArray) {
        
        int i;
        for(i=0; i < TamanhoArray ; i++ ) {
            Array[i] *= 2;
        }
    }

    static int[] MontarArray(int TamanhoArray) {
        
        int[] Array_original = new int[TamanhoArray];
        System.out.println("Insira os elementos do Array");
        int i;
        for(i=0; i<TamanhoArray ; i++){
        Array_original[i] = Scanner.nextInt();
        }
        return Array_original;
    }
}
