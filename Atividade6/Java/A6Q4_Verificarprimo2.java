import java.util.Scanner;

//implementação feita baseada no código anterior

public class A6Q4_Verificarprimo2 {
    public static void main(String[] args){
        Scanner Scanner = new Scanner(System.in);
        //Todo número é divisível por 1 e por ele mesmo, mas se for somente por estes, é primo
        //então da pra pular o 1, pois naturaçmente será divisível por ele
        //NESSE NOVO CASO É POSSÍVEL PARTIR PELO DIVISOR DIRETO DO 3, podendo pular de 3 em 3
        //considerando que o conceito de números primos na matemática clássica é restrito ao conjunto
        //dos números naturais, essa busca pode ser feita com o cálculo incremental
        //A teoria dos anéis permite aplicar o conceito de primos a todos os inteiros
        //entretando, nesse exercício será usada a ideia da matemática clássica
        int divisor = 3;
        int Numero_inserido = Scanner.nextInt() ;
        boolean primo = true;

        /* Ponto da Implementação nova, a regra pela raiz:
        *Se um número N é divisível por A, então N = A * B.
        *assim, se A for maior que a raiz de N, então B obrigatoriamente tem que ser menor que a raiz
        *então se nenhum divisor for encontrado até a raiz do número inserido a busca pode parar
        *pois se o número fosse não primo, o divisor menor já teria sido encontrado
        *também é possível testar previamente se é divisível por 2 (par) e ir pulando de 2 em 2
        */
        if (Numero_inserido <= 1) {
            primo = false;
        }
        
        //se um número for par e maior que 2, ele não será primo
        if (Numero_inserido % 2 == 0 && Numero_inserido != 2) {
            primo = false;
        }

       while (divisor * divisor <= Numero_inserido) {
            if (Numero_inserido % divisor == 0) {
                primo = false;
                break;
            }
            divisor += 2; 
        }

        if (primo) {
            System.out.println("O número é primo");
        } else {
        System.out.println("O número não é primo");
        }

    }
}
