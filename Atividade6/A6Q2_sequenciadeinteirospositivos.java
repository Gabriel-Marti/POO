import java.util.Scanner;

public class A6Q2_sequenciadeinteirospositivos {
    
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int acc = 0; //acc para acumuladora é minmônico, conta quantos numeros são positivos
        int Numero_inserido = 1;

        while (Numero_inserido != 0) {
            Numero_inserido = Scanner.nextInt();
            if (Numero_inserido > 0) {
                acc++;
            }
        }
        System.out.println("Total de números positivos entre os inseridos: " + acc);

    }
}
