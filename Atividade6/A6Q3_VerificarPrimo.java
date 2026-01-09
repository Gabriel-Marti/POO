import java.util.Scanner;

public class A6Q3_VerificarPrimo {
    public static void main(String[] args){
        Scanner Scanner = new Scanner(System.in);
        //Todo número é divisível por 1 e por ele mesmo, mas se for somente por estes, é primo
        //então da pra pular o 1, pois naturaçmente será divisível por ele e ir direto pro 2 
        //considerando que o conceito de números primos na matemática clássica é restrito ao conjunto
        //dos números naturais, essa busca pode ser feita com o cálculo incremental
        //A teoria dos anéis permite aplicar o conceito de primos a todos os inteiros
        //entretando, nesse exercício será usada a ideia da matemática clássica
        int divisor = 2;
        int Numero_inserido = Scanner.nextInt() ;
        boolean primo = true;

        while (divisor != Numero_inserido ) {

            //como o conceito de primos é aplicado para inteiros maiores que 1
            //emtão se o número for maior que 1 a busca ocorre normalmente
            if (Numero_inserido > 1) {
                if (Numero_inserido%divisor == 0) {
                    primo = false; //se o número inserido for divisível, então é primo
                    break; //se foi determinado como primo não há necessidade em encotrar um loop
                } else { divisor++; } //se não for encontrado, prossegue com a busca
            
            //se for menor ou igual a 1 então não é primo
            } else {
                primo = false;
                break; //se for menor ou igual a 1, quebra o loop
            }
        }

        if (primo) {
            System.out.println("O número é primo");
        } else {
        System.out.println("O número não é primo");
        }

    }
}
