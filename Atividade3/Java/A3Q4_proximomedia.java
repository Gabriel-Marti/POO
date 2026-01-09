import java.util.Scanner;

public class A3Q4_proximomedia {
    public static void main(String[] Args){
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o primeiro numero");
        double numero1 = Scanner.nextDouble();
        System.out.println("Insira o segundo numero");
        double numero2 = Scanner.nextDouble();
        System.out.println("Insira o terceiro numero");
        double numero3 = Scanner.nextDouble();
        
        double media = (numero1 + numero2 + numero3)/3;

        //caso em que numero1 é o mais proximo
        if (Math.abs(numero1-media) < Math.abs(numero2-media) && Math.abs(numero1-media) < Math.abs(numero3-media)) {             
         System.out.printf("%.f é o número mais próximo da média", numero1);
         //caso em que numero2 é o mais proximo
    } else if (Math.abs(numero2-media) < Math.abs(numero3-media) && Math.abs(numero2-media) < Math.abs(numero1-media)) {
        System.out.printf("%.f é o número mais próximo da média", numero2);
        //caso em que o numero 3 é o mais próximo
    } else if (Math.abs(numero3-media) < Math.abs(numero2-media) && Math.abs(numero3-media) < Math.abs(numero1-media)) {
        System.out.printf("%.f é o número mais próximo da média", numero3);
        //se nenhuma das opções acima for válida então algum dos números é igual, supor o 1
    } else if (numero1 == numero2 || numero1 == numero3) {
        System.out.printf("%.f é o número mais próximo da média", numero1);
        //se o 1 não é o igual, então só pode ser o 2, se for o 3 cai nos casos anteriores
    } else { System.out.printf("%.f é o número mais próximo da média", numero2); }

}
    
}
