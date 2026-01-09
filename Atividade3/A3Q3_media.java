import java.util.Scanner;

public class A3Q3_media {
    public static void main(String[] Args){
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o primeiro numero");
        double numero1 = Scanner.nextDouble();
        System.out.println("Insira o segundo numero");
        double numero2 = Scanner.nextDouble();
        System.out.println("Insira o terceiro numero");
        double numero3 = Scanner.nextDouble();
        
        double media = (numero1 + numero2 + numero3)/3;


        int totalAcima = acimaDaMedia(numero1, numero2, numero3, media);

        System.out.printf("%d números estão acima da média",totalAcima);

    }

     static int acimaDaMedia(double n1, double n2, double n3, double m) {
        int acumuladora = 0;

        if (n1 > m) {
            acumuladora++;
        }
        if (n2 > m) {
            acumuladora++;
        }
        if (n3 > m) {
            acumuladora++;
        }
        return acumuladora;

    }
}

