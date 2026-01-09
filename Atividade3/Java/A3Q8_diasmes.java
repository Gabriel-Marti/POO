import java.util.Scanner;

public class A3Q8_diasmes {
    public static void main(String[] Args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o mês");
        int mes = Scanner.nextInt();
        System.out.println("Insira o ano");
        int ano = Scanner.nextInt();
        boolean bissexto = verificarBissexto(ano);

        switch (mes) {
            case 2:
                if (bissexto == true) {
                    System.out.println("O mês tem 29 dias");
                } else { System.out.println("O mês tem 28 dias"); }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("O mês tem 30 dias");
                break;
            default:
                System.out.println("O mês tem 31 dias");
                break;
        }


    }

    static boolean verificarBissexto(int ano) {
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400==0 ){
            return true;
        } else { return false; }
    }

    

}
