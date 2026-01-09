import java.util.Scanner;

/**Dividindo as taxas
    * Taxa a: Até 99 KWh: R$1.35
    Taxa b: 100 até 299 KWh: R$1.55
    Taxa c: 300 até 574 KWh: R$1.75
    Taxa d: Maior ou igual a 575 KWh: R$2.15
    
    Há um problema aqui, "até 574" implica que ao passar de 574 não vale mais
    Enquanto "maior ou igual a 575" implica que se for menor que 575 não vale mais
    Mas se for entre 574 e 575?
    Assumi que valeria a taxa d
    na verdade isso vale pra qualquer numero entre as taxas, vou assumir que passa para a taxa seguinte
    */

public class A3Q6_calculokWh {
    public static void main(String[] Args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira qual o consumo de kWh");
        double consumo = Scanner.nextDouble();
        double preco_total; 
        
        //essas condicionais vão quebrando o preço para taxar adequadamente
        if (consumo >= 574) { //taxa d
            preco_total = calculoD(consumo - 574);
            preco_total += calculoC(275.0) + calculoB(200) + calculoA(99);
        } else if (consumo <= 99) { //taxa a
            preco_total = calculoA(consumo);
        } else if (consumo <= 299) { //taxa b
            preco_total = calculoB(consumo - 99) + calculoA(99); 
        } //chegando aqui o consumo só pode ser maior que 299 e menor que 274, caindo na taxa c
        else { preco_total = calculoC(consumo - 299) + calculoB(200) + calculoA(99); }

        
        //Se o consumo for maior que 300kWh, ele será taxado
        if (consumo > 300) {
            preco_total = preco_total * 1.1;
        }

        //se após todo o processo o total for menor que o minimo, o total vira o minimo
        if (preco_total < 35) {
            preco_total = 35;
        }
    

        System.out.printf("O valor da conta elétrica é %.2f", preco_total);

    }

    //Taxa a: Até 99 KWh: R$1.35
    static double calculoA(double valor) {
        return valor* 1.35;
    }

    //Taxa b: 100 até 299 KWh: R$1.55
    static double calculoB(double valor) {
        return valor* 1.55;
    }

    //Taxa c: 300 até 574 KWh: R$1.75
    static double calculoC(double valor) {
        return valor* 1.75;
    }

    //Taxa d: Maior ou igual a 575 KWh: R$2.15
    static double calculoD(double valor) {
        return valor* 2.15;
    }
    
}
