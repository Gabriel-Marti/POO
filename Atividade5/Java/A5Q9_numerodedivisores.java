import java.util.Scanner;

public class A5Q9_numerodedivisores {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt(); //lendo o número n
        int acc=0; //acumuladora
        int i;
        for(i=1 ; i <= n ; i++ ) {
            if (n%i == 0) {
                acc++;
            }
        }

        System.out.println("O número "+ n + "tem " + acc + " divisores" );
    }

}
