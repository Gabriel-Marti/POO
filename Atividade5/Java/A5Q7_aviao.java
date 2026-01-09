//vou me basear no meu código, que usei para responder a questão na atividade anterior

import java.util.Scanner;

public class A5Q7_aviao {
    //alterando a quantidade de assentos
    private static final int TotalAssentos = 40;
    //as 3 primeiras filas dizem respeito das cadeiras do 1 ao 12
    //considerando as filas em contagem vertical
    private static final int limite_primeira_classe = 12;

    public static void main(String[] args) {
        A5Q7_aviao gerenciador = new A5Q7_aviao();


        gerenciador.ExibirAssentos();
        System.out.println(" ");

        gerenciador.EscolherAssento();

        System.out.println(" ");

        gerenciador.ExibirAssentos();

    }
    

    private boolean[] ocupacao;
    
    public A5Q7_aviao() {
        this.ocupacao = new boolean[TotalAssentos];
        Scanner Scanner = new Scanner(System.in);

        this.ocupacao[0] = true; // Assento 1
        this.ocupacao[1] = true; 
        this.ocupacao[14] = true; 
        this.ocupacao[16] = true; 
        this.ocupacao[39] = true; // Assento 40

    }

    

    //metodo para imprimir o estado dos assentos
    void ExibirAssentos() {
        int acc=0; //aculumadora para controlar a organização
        int acc2=0; //segunda acumuladora para controlar o loop da organização
        int i;
        int numAssento;
        String Estado;
        for(i = 0 ; i < TotalAssentos ; i += 4){ //nesse caso é 4 para seguir a numeração da linha 
        numAssento = i + 1; //o numero do assento é a posição dele na lista acrescido de 1

        

        if (ocupacao[i] == true ) {
            Estado = "X";
        } else { Estado = ""; }

        
        if (acc2 < 4) { //o loop deve se repetir 4 vezes, pois são 4 linhas
            //esse loop faz as linhas, sendo repetido 4 vezes
            //sistemade de condicional apra que a exibição fique igual no exemplo
            //depois de imprimir quase todas as cadeiras de uma linha a acumuladora passada do limite
            //ai cai no else e imprime com println, indo para a próxima linhas
            //a acumuladora e o i são redefinidos
            if (acc < 9) {
            System.out.print(numAssento + Estado + " ");
            acc++; 
            } else {  System.out.println(numAssento + Estado + " ");
                        acc = 0;
                        acc2++;
                        //subtraindo -4 para anular o incremento pós iteração
                        //e usando a segunda acumuladora para guiar e controlar os saltos da iteração
                        i = -4 + acc2; //reseta o i para repetir o loop formando as próximas linhas
                    } //quando acc3=4 o loop ocorreu 4 vezes e as 4 linhas foram formadas
        } else { i=40; } //então, quando acc4=4 o loop encerra, a condição para
        }
    }

    



    //método responsável pelo sistema de escolha requisitado
    void EscolherAssento() {
        Scanner Scanner = new Scanner(System.in);
        Boolean lotado = checarLotacao(ocupacao);
        if (lotado == true) {
            System.out.println("O avião está lotado");
        } else {

            System.out.println("Deseja escolher o assento? S/N");

            String Resposta = Scanner.nextLine();
            if (Resposta.equalsIgnoreCase("S")) {
                System.out.println("A reserva é para primeira classe? S/N");
            Resposta = Scanner.nextLine();
                if (Resposta.equalsIgnoreCase("S")) { 
                    System.out.println("Insira o assento de 1 a 12");
                    int numeroAssento = Scanner.nextInt();
                    OcuparPrimeiraClasse(numeroAssento);
                } else if (Resposta.equalsIgnoreCase("N")) {
                    System.out.println("Insira o assento de 13 a 40");
                    int numeroAssento = Scanner.nextInt();
                    OcuparClasseEconomica(numeroAssento);
                } else { System.out.println("Programa encerrado");
                         System.exit(0);
                }
                
            } else if (Resposta.equalsIgnoreCase("N")) {
                System.out.println("A reserva é para primeira classe? S/N");
                Resposta = Scanner.nextLine();
                if (Resposta.equalsIgnoreCase("S")) {
                    OcuparPrimeiraClasseAutomatica();
                } else if (Resposta.equalsIgnoreCase("N")) {
                    OcuparClasseEconomicaAutomatica();
                }  else { System.out.println("Programa encerrado");
                         System.exit(0);
                }

            } else { System.out.println("Opcao Invalida");
                        System.exit(0);
                    }


        }
    }


    //checa se o avião está lotado
     boolean checarLotacao(boolean[] lista) {
        int acc;
            //itera sobre todos os assentos se encontrar algum livre retorna false
            for (acc = 0 ; acc <TotalAssentos ; acc++) {
                if (lista[acc] == false) {
                    return false;
                }
            }
            return true;
        }



    //seleciona o assento para primeira classse
    void OcuparPrimeiraClasse(int numeroAssento) {
        if (numeroAssento > 0 && numeroAssento <= limite_primeira_classe && ocupacao[numeroAssento - 1] == false) {
            ocupacao[numeroAssento - 1] = true;
        } else { System.out.println("Programa encerrado");
                System.exit(0);
        }
    }

    //seleciona o assento para classe economica
    void OcuparClasseEconomica(int numeroAssento) {
        if (numeroAssento > limite_primeira_classe && numeroAssento <= TotalAssentos && ocupacao[numeroAssento - 1] == false) {
            ocupacao[numeroAssento - 1] = true;
        } else { System.out.println("Programa encerrado");
                 System.exit(0);
        }
    }

    //seleciona automaticamente um assento na primeira classe
    void OcuparPrimeiraClasseAutomatica() {
        for (int i = 0; i < limite_primeira_classe; i++) {
            if (!ocupacao[i]) {
                ocupacao[i] = true;
                System.out.println("Assento automático de 1ª Classe reservado: " + (i + 1));
                return;
            }
        }
    }

    //seleciona automaticamente um assento ma classe economica
    void OcuparClasseEconomicaAutomatica() {
        for (int i = limite_primeira_classe; i < TotalAssentos; i++) {
            if (!ocupacao[i]) {
                ocupacao[i] = true;
                System.out.println("Assento automático Econômica reservado: " + (i + 1));
                return;
            }
        }
    }
}
