import java.util.Scanner;

public class A6Q6_outrometodoraiz {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira um número para que seja calculada a raiz inteira dele");
        int numero = Scanner.nextInt();
        int contador = 0; //conta o número de vezes que a operação foi efetuada, é a raiz inteira
        int parametroParaSubtracao = 1;

        while (numero >= 0) {
            numero -= parametroParaSubtracao;
            parametroParaSubtracao += 2;
            contador++;
        }
        //como o loop vai acabar rodando mais de uma vez é preciso subtrair em 1 para achar a raiz
        contador--;
        
        System.out.println(contador);
    }
}
