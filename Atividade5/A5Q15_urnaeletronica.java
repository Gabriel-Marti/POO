import java.util.Scanner;

//para não precisar fazer em arquivos diferentes fiz a classe principal e as demais no mesmo código
public class A5Q15_urnaeletronica {
    static Scanner Scanner = new Scanner(System.in);

    //O main cria uma lista com os candidatos usando o objeto Registro, vindo da classe RegistroCandidatos
    //O main pega essa lista e passa para o objeto urna, instanciado a partir da classe UrnaEleitoral 
    //O objeto urna processa os votos e apura a eleição, determinando o vencedor
    public static void main(String[] args) {

        //adquirindo as informações com o usuário
        System.out.println("Insira o número de candidatos");
        int TotalCandidatos = Scanner.nextInt();
        System.out.println("Insira o número de eleitores");
        int eleitores = Scanner.nextInt();

        //apenas para evitar o bug do enter após o Scanner.nextInt usado anteriormente
        //isso faz com que nenhum candidato seja pulado
        Scanner.nextLine();

        //instanciando objetos a partir das classes, para executar e testar o código
        RegistroCandidatos Registro = new RegistroCandidatos(TotalCandidatos);
        UrnaEleitoral urna = new UrnaEleitoral();

        //loop para cadastrar candidatos
        int i;
        for(i = 1 ; i<=TotalCandidatos ; i++ ){
             Registro.CadastrarCandidatos();
        }

        //a partir da lista de candidatos criados na urna
        Candidato[] Registro_de_candidatos = Registro.Lista_de_candidatos;


        //abre a votação e inicializa a urna
        urna.AbrirVotacao();
        urna.InicializarUrna(Registro_de_candidatos);

        //loop para relizar a votação baseado no número de eleitores, reaproveitando a variavel i
        for(i=1 ; i<=eleitores ; i++ ){
            urna.RealizarVotacao();
        }

        //depois que todos os eleitores votarem, a votação fecha e os resultados são apurados
        urna.FecharVotacao();

        //o código é executado com sucesso, fazendo o que foi requisitado na questão
    }
    //abaixo estão as classes usadas para que este código funcionasse


    //o molde para fazer um objeto candidato
    //a questão disse pelo menos 3 classes, isso significa que podem ser usadas mais que 3
    static private class Candidato {
         String Nome;
         int NumeroAtribuido;
        
        //construtor de objetos candidato
        public Candidato(String nome, int Numero) {
            this.Nome = nome;
            this.NumeroAtribuido = Numero;
        }
    }



    //classe onde o registro do candidato é feito, como pedido
    private static class RegistroCandidatos {
        //Como os números atrbuidos aos candidatos são sequenciais, isso vai garantir a sequencia
        private int NumeroSequencial = 1;
        private int NumerodeCandidatos;
        private Candidato[] Lista_de_candidatos;
        //conta quantos candidatos efetivamente estão cadastrados, desconsiderando espaços vazios
        //vai guiar para saber onde um novo candidato deve ser colocado
        int ContadordeCandidatos = 0; 
        //Os objetos criados aqui serão arrays que funcionam como registros de candidatos
        // a príncipio vazios, que listam os candidatos
        public RegistroCandidatos(int NumerodeCandidatos) {
            //um array de objetos(candidatos) é instanciado, e começa vazio
            //o espaço dele é definido pelo número de candidatos
            this.Lista_de_candidatos = new Candidato[NumerodeCandidatos];
            this.ContadordeCandidatos = 0; 
        }

        //método para cadastrar candidatos
       public void CadastrarCandidatos() {
        String NumeroDoCandidato;
        System.out.println("Insira o nome do candidato");
         String nome = Scanner.nextLine();
         Candidato candidato = new Candidato(nome, NumeroSequencial);
         Lista_de_candidatos[ContadordeCandidatos] = candidato;

        NumeroSequencial++;
        ContadordeCandidatos++;
       }

       //Método para formatar os candidatos em um array, para que sejam exibidas as opções
       //ACABEI DESCARTANDO A IDEIA
      // public Candidato[] ListarCandidatos() {
     //   System.out.println("Insira o número de candidatos");
      //  int NumerodeCandidatos = Scanner.nextInt();
      //  Candidato[] Lista_de_candidatos = new Candidato[NumerodeCandidatos];
     //   int i;
     //   for(i= 0 ; i < NumerodeCandidatos ; i++) {
     //       Lista_de_candidatos[i] = CadastrarCandidatos();
     //   }

     //   return Lista_de_candidatos
     //  }

    }



    //Classe da urna eletrônica pedida
    private static class UrnaEleitoral  {
        /**eu pensei e fazer dos votos um atributo dos objetos candidato, para facilitar a contagem
         * mas como o enunciado disse que na primeira classe serão nome número votos não se encaixaria
         * então vou fazer a contagem de votos usando arrays paralelos, array de objetos e de inteiros
         * assim o indíce de um elementos no array de inteiros corresponderá ao número de votos 
         * de determinado candidato de mesmo indíce no array de objetos
         * enquanto os votos brancos, nulos e totais serão salvos por variáveis 
         */ 

        private Candidato[] candidatos;
        private int[] Lista_votos;
        private int Total_Votos;
        private int Total_Votos_Validos;
        private int votosBrancos;
        private int votosNulos;
        private boolean aberta;
        

        public void InicializarUrna(Candidato[] lista ) {
            this.candidatos = lista;
            //o array que conta votos terá mesmo tamanho que o com candidatos
            this.Lista_votos = new int[lista.length];

            //exibir lista com os candidatos
            int i;
            for(i=0 ; i<lista.length ; i++ ) {
                if (lista[i] != null) {
                    System.out.println( candidatos[i].Nome + " Nº " + candidatos[i].NumeroAtribuido  );
                }
            }

        }

        public void AbrirVotacao() {
            this.aberta = true;
            System.out.println("A votação está aberta");
        }

        public void FecharVotacao() {
            this.aberta = false;
            System.out.println("A votação está fechada");
            ApurarResultados();
            System.exit(0);
        }
        
        public void RealizarVotacao() {
            System.out.println("Insira o número do candidato que irá votar");
            int voto = Scanner.nextInt();
            
            if (voto == 0) {
                this.votosBrancos++;
                System.out.println("Voto computado: branco");
            }
            else {
                //definir nulo por padrão, depois usar loop para comparar os números
                //se o valor inserido tiver na lista o nulo é definido como falso
                boolean VotoNulo = true;
                int i;
                for(i= 0 ; i<candidatos.length ; i++ ) {
                    //o i vai sendo incrementado até atingir o valor máximo, que é o tamanho do array
                    //se os números dos candidatos são sequenciais e i começa de 0+1 até o final
                    //então se o voto inserido foi para algum candidato em algum momento i+1 terá o mesmo
                    //valor que o do voto inserido, ou seja, se i+1 = voto, então o eleitor votou no
                    //candidato que está no indíce i do array  com a lista de candidatos
                    //assim basta incrementar em 1 o número de votos a este candidato no array de votos
                    //i+1 pois a sequencia dos indices do array começa de 0 e a sequencia de números 
                    //atribuidos aos candidatos começa de 1
                    if ( i + 1 == voto  ) {
                        Lista_votos[i] ++;
                        Total_Votos_Validos++;
                        VotoNulo = false;
                        System.out.println("Voto computado para: " + candidatos[i].Nome);
                        break; //não tem motivo para continuar o loop
                    }
                }
                if (VotoNulo) {
                    votosNulos++;
                    System.out.println("Voto Computado: Nulo");
                }
            }

            Total_Votos++;

        }


        //Para apurar o resultado foram desconsiderados casos onde existe empate
        public void ApurarResultados() {
            System.out.println("--RESULTADO DA ELEIÇÃO--");

            //assumir que o vencedor foi o primeiro, depois fazer um loop pela lista que conta votos
            //então após o loop, o vencedor será aquele com mais votos
            Candidato vencedor = candidatos[0];
            int IndiceDoCandidatoVencedor = 0;

            int i;
            //como o inicial ja foi definido, começar a partir do segundo (indice 1)
            for(i=1 ; i<candidatos.length ; i++  ) {
                if (Lista_votos[i] > Lista_votos[IndiceDoCandidatoVencedor]) {
                    IndiceDoCandidatoVencedor = i;
                    vencedor = candidatos[IndiceDoCandidatoVencedor];
                }
            }

            //Declarar o vencedor
            if (Total_Votos_Validos == 0) {
                //talvez todos os votos sejam brancos ou nulos, assim não haveria vencedor
                System.out.println("Não houve vencedor");
            } else {
                System.out.println("O vencedor da eleicao é: " + vencedor.Nome);
            }
            

            //apenas para formatar
            System.out.println(" ");

            //vai exibir o total de votos de cada candidato
            for(i=0 ; i<candidatos.length ; i++ ) {
                System.out.println(candidatos[i].Nome + ": " + Lista_votos[i] + " votos" );
            }

            System.out.println("Total de votos: " + Total_Votos);
            System.out.println("Votos válidos: " + Total_Votos_Validos);
            System.out.println("Votos brancos: " + votosBrancos);
            System.out.println("Votos nulos: " + votosNulos);

        }

    }
}
