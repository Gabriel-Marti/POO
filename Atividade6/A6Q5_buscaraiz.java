import java.util.Scanner;

public class A6Q5_buscaraiz {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o número para calcular a raiz inteira");
        //as variáveis pedidas pelo enunciado
        int n = Scanner.nextInt();
        int r = 0;
        
        //a raiz é calculada pela fórmula de busca sequencial dada na questão
        //vai buscando de 0 a n até achar a raiz r desejada
        while (r*r < n+1) {
            r++;
        }
        
        //como r foi incrementado, para preservar o valor é preciso subtrair em 1
        r--;

        System.out.println(r);
    }
}
