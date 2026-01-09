
import java.util.Scanner;

public class A4Q4_assentosvoo {
    private static final int TotalAssentos = 16;
    private static final int limite_primeira_classe = 4;

    public static void main(String[] args) {
        A4Q4_assentosvoo gerenciador = new A4Q4_assentosvoo();


        gerenciador.ExibirAssentos();

        gerenciador.EscolherAssento();

        System.out.println(" ");

        gerenciador.ExibirAssentos();

    }
    

    private boolean[] ocupacao;
    
    public A4Q4_assentosvoo() {
        this.ocupacao = new boolean[TotalAssentos];
        Scanner Scanner = new Scanner(System.in);

        this.ocupacao[0] = true; // Assento 1
        this.ocupacao[2] = true; 
        this.ocupacao[5] = true; 
        this.ocupacao[6] = true; 
        this.ocupacao[9] = true; 
        this.ocupacao[10] = true; // Assento 11

    }


    //metodo para imprimir o estado dos assentos
    void ExibirAssentos() {
        int i;
        int numAssento;
        String Estado;
        for(i = 0 ; i < 16 ; i++) {
        numAssento = i + 1; //o numero do assento é a posição dele na lista acrescido de 1
        if (ocupacao[i] == true ) {
            Estado = "X";
        } else { Estado = ""; }

        System.out.print(numAssento + Estado + " ");
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
                    System.out.println("Insira o assento de 1 a 4");
                    int numeroAssento = Scanner.nextInt();
                    OcuparPrimeiraClasse(numeroAssento);
                } else if (Resposta.equalsIgnoreCase("N")) {
                    System.out.println("Insira o assento de 5 a 16");
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
            for (acc = 0 ; acc <16 ; acc++) {
                if (lista[acc] == false) {
                    return false;
                }
            }
            return true;
        }



    //seleciona o assento para primeira classse
    void OcuparPrimeiraClasse(int numeroAssento) {
        if (numeroAssento > 0 && numeroAssento <= 4 && ocupacao[numeroAssento - 1] == false) {
            ocupacao[numeroAssento - 1] = true;
        } else { System.out.println("Programa encerrado");
                System.exit(0);
        }
    }

    //seleciona o assento para classe economica
    void OcuparClasseEconomica(int numeroAssento) {
        if (numeroAssento > 4 && numeroAssento <= 16 && ocupacao[numeroAssento - 1] == false) {
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
