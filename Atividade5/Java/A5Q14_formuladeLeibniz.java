import java.util.Scanner;

public class A5Q14_formuladeLeibniz {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Insira os n primeiros termos para calcular pi pela formula de leibniz");
        int n = Scanner.nextInt();
        double resultado = Calcular_pi_por_Leibniz(n);
        System.out.println("O valor de pi é aproximadamente " + resultado);
        
    }

    static double Calcular_pi_por_Leibniz(int n){
        
        double SomaAcumulada = 1; //variável acumuladora
        int i; //nesse caso i deve ser double para a conta funcionar bem
        //como eu to contando a partir do 0, o i não pode ser igual a n, assim i<n
        //pois se for igual vai fazer uma conta a mais
        for (i=0 ; i < n ; i++) { 
            //definindo a primeira soma como indíce 0 e a partir dai contando o indice da soma
            //é notável que as somas de indices pares são  com números negativos (subtração)
            //enquanto as de indíce ímpar são com números positivos, então é uma soma normal
            //é mais conveniente contar a partir de indíce 0 nesse caso pois facilita a organização
            //do algoritmo, fazendo as operações em função do indíce i
            if (i%2 == 0) { 
                SomaAcumulada -= 1.0/(3+2*i); //1.0 para garantir que o resultado seja um double
            } else {
                SomaAcumulada += 1.0/(3+2*i); //1.0 para garantir que o resultado seja um double
            }
        }
        //tem que multiplicar por 4 para chegar em pi, a precisão cresce com n
        double resultado = 4*SomaAcumulada; 
        return resultado;
        
    }
}
