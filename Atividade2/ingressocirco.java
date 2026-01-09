import java.util.Scanner;

//conforme a atividade pede, foram feitos exercícios com o scanner
//cono não foi especificado a quantia, apenas citado o plural "alguns" fiz 2 que deve ser suficiente
//o scanner pega as configurações da região do sistema operacional
//Então vírgula(,) para detectar decimal. não ponto(.)
void main() {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insira o preço do ingresso:");
        double preco_ingresso = scanner.nextDouble();
    
    System.out.println("Insira sua idade:");
        int idade = scanner.nextInt();

    double novoprecoIngresso;

    if (idade <= 18 || idade >= 60) {
        novoprecoIngresso = preco_ingresso*0.5;
    } else {
        novoprecoIngresso = preco_ingresso*0.9;
    }

    System.out.println("O valor do ingresso é: " + novoprecoIngresso);

}
