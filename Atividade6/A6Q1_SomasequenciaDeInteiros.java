import java.util.Scanner;


public class A6Q1_SomasequenciaDeInteiros {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int SomaTotal = 0; //acumuladora, vai realizar a soma total
        //variavel para salvar o numero inserido, controla o loop, definida como 1 inicialmente
        //para o loop não quebrar
        int Numero_inserido = 1; 
        while (Numero_inserido != 0) {
            Numero_inserido = Scanner.nextInt();
            SomaTotal += Numero_inserido;
        }

        System.out.println("A soma total é " + SomaTotal);

    }
}
