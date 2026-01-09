import java.util.Scanner;
//fiz esse programa consdierando que um número x de livros será dividido entre n alunos
//a partir disso é possível chegar no conceito do enunciado da questão

public class A3Q1_ListaLivros {
    
    public static void main(String[] Args){

        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o número de livros");
        int livros = Scanner.nextInt();
        System.out.println("Insira o número de pessoas");
        int pessoas = Scanner.nextInt();
        
        if (livros == 0) {
            //se houverem 0 livros não vai ser possível atribuir conceito para grupo nenhum
            //uma vez que os conceitos estão previstos em np minimo um livro
            //não faz sentido pensar em 0 livros para n alunos
            System.out.println("Não é possível dividir 0 livros para o grupo");
        } else {
            int divisao = pessoas/livros;

            if (divisao <= 8) {
                System.out.println("A");
            } else if (divisao >= 9 && divisao <= 12) {
                System.out.println("B");
            } else if (divisao >= 13 && divisao <= 18 ) {
                System.out.println("C");
            } else { System.out.println("D"); }

        }

        
    }


}
