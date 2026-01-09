import java.util.Scanner;
//conforme a atividade pede, foram feitos exercícios com o scanner
//cono não foi especificado a quantia, apenas citado o plural "alguns" fiz 2 que deve ser suficiente
//o scanner pega as configurações da região do sistema operacional
//Então vírgula(,) para detectar decimal. não ponto(.)

void main () {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insira os 3 números para que a média seja calculada");

    double numero1 = scanner.nextDouble();
    double numero2 = scanner.nextDouble();
    double numero3 = scanner.nextDouble();

    double media = (numero1 + numero2 + numero3)/3;

    System.out.println("A média é:" + media);
}
