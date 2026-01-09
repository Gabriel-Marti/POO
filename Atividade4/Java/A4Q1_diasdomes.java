import java.util.Scanner;


public class A4Q1_diasdomes {
    public static void main(String[] args) {
        int[] diasDoMes = {31, 28, 31, 30, 31, 30,
                        31, 31, 30, 31, 30, 31};
        
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o ano");
        int ano = Scanner.nextInt();
        System.out.println("Insira o mes");
        int mes = Scanner.nextInt();
        boolean bissexto = verificarbissexto(ano);

        if (bissexto == true) {
            diasDoMes[1] += 1;
        }

        var dias = diasDoMes[mes-1];

        System.out.printf("O número de dias no mês é %d\n", dias);

        //retornando o estado inicial só para o cenário hipotético em que a verificação de dias
        //se repetisse, assim o numero de dias de fevereiro sempre seráa 28 a menos que o ano
        //seja bissexto, onde o retorno será 29, depois o numero no array voltará a 28 dias
        if (diasDoMes[1] == 29) {
            diasDoMes[1] -= 1;
        }

        

    }

    static boolean verificarbissexto(int ano) {
        if (ano%4==0 && ano%100 != 0 || ano%400 == 0) {
            return true ; 
        } else { return false; }

    }

    

}