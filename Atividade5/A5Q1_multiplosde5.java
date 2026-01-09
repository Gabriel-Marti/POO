import java.util.Scanner;

public class A5Q1_multiplosde5 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Dado o intervalo de 2 números, serão exibidos todos os múltiplos de 5");
        System.out.println("Insira o primeio número");
        int primeiro = Scanner.nextInt();
        System.out.println("Insira o último número");
        int ultimo = Scanner.nextInt();

        int i;
        for(i=primeiro + 1 ; i < ultimo ; i++) {

            if (i%5 == 0) {
                System.out.println(i);
            }
        }
    }

  
}
