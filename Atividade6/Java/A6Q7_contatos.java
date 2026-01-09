import java.util.Scanner;

class Contato{

        private String Nome;
        private String Numero;

        public Contato(String nome, String numero) {
            this.Nome  = nome;
            this.Numero = numero;
        }

        public String Getnome() {
            return this.Nome;
        }

        public String GetNumero() {
            return this.Numero;
        }

        public void MudarNumero(String NovoNumero) {
            this.Numero = NovoNumero;
        }

    }

public class A6Q7_contatos2 {

    //classe secundária usada para criar objetos contato, usados para formar a lista de contatos
    
    private Contato lista_de_contatos[]; //lista de objetos Contato
    //como não foi especificado para deixar a lista infinita eu não vou fazer isso
    private int TAMANHO_MAXIMO;
    private int TAMANHO_REAL;


    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        //eu poderia definir o tamanho máximo por padrão, mas vou deixar para o usuário mesmo
        System.out.println("Insira o tamanho máximo da lista de contatos");
        int Espaco_maximo_da_lista = Scanner.nextInt();
        System.out.println("Insira o numero de contatos que serão adicionados");
        int Numero_de_contatos = Scanner.nextInt();
        //limpeza de buffer
        Scanner.nextLine();

        A6Q7_contatos2 lista = new A6Q7_contatos2(Espaco_maximo_da_lista);

        int i;
        for(i=0 ; i<Numero_de_contatos ; i++) {
            System.out.println("Insira o nome do contato");
            String nome = Scanner.nextLine();
            System.out.println("Insira o numero do contato");
            String numero = Scanner.nextLine();

            lista.AdicionarContato(nome, numero);

        }

        lista.ExibirLista();


        System.out.println("Insira um nome ou numero para remover");
        //pode digitar qualuqer coisa numa opcao desde que digite corretamente em pelo menos um
        lista.RemoverContato(Scanner.nextLine(), Scanner.nextLine());
        lista.ExibirLista();

        System.out.println("Insira um nome e em seguida o numero novo para atualizar");
        lista.AtualizarContato(Scanner.nextLine(), Scanner.nextLine());
        lista.ExibirLista();

        System.out.println("Insira um nome para pesquisar o número");
        String numero = lista.Pesquisar(Scanner.nextLine());
        if (numero == null) {
            System.out.println("O contato não existe");
        } else {
            System.out.println("O número em questão é " + numero);
        }

    }

    public A6Q7_contatos2(int tamanhoMAX) {
        this.TAMANHO_MAXIMO = tamanhoMAX;
        this.lista_de_contatos = new Contato[tamanhoMAX];
        this.TAMANHO_REAL = 0; //lista começa vazia

        //inicializa a lista com 2 contatos padrão, somente para ter
       // lista_de_contatos[0] = new Contato("Giovanny", "55998887777"); //numero aleatorio
        //lista_de_contatos[1] = new Contato("Joao", "55998881111");
        //TAMANHO_REAL = 2;
    }

    public void AdicionarContato(String nome, String numero) {
      if ( TAMANHO_REAL == TAMANHO_MAXIMO) {
        System.out.println("Erro, sem espaço na lista, delete algum contato se quiser adicionar um novo");
        
      }
       else if (VerificarNome(nome, numero)) { //se retornar true, então a busca encontrou dado já registrado
        System.out.println("Esse nome/número já está(ão) registrado(s)");
      } else { //se não, registra
        lista_de_contatos[TAMANHO_REAL] = new Contato(nome, numero);
        TAMANHO_REAL++;
      }

    }

    private boolean VerificarNome(String nome, String numero) {
        
        int i;
        for(i=0 ; i<TAMANHO_REAL ; i++ ) {
            if ( lista_de_contatos[i].Getnome().equals(nome) || lista_de_contatos[i].GetNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public void RemoverContato(String nome, String numero){
        int i;
        for(i=0 ; i<TAMANHO_REAL ; i++ ) {
            if (lista_de_contatos[i].Getnome().equals(nome) || lista_de_contatos[i].GetNumero().equals(numero)) {
                lista_de_contatos[i] = null;
                TAMANHO_REAL--;
                ReordenarLista(i); //manda o indice do Contato excluido na lista, reordenar
                return;

            }
        }
        System.out.println("Erro, o contato não está na lista");
    }


    //baseado no indice do Contato excluido vai reordenar os contatos seguintes na lista
    //assim, evitando espaços vazios 
    private void ReordenarLista(int Indice) {
        
        int i;
        
        for(i= 0 ; i< (TAMANHO_REAL - Indice) ; i++) {
            //substitui o espaço vazio (de indice igual ao número removido) pelo seu consequente
            //substitui os seguintes pelos seus seguintes e reordena a lista de contatos.
            lista_de_contatos[Indice + i] = lista_de_contatos[Indice +1 + i];
        }
        //limpa o ultimo para não ficar duplicado
        lista_de_contatos[Indice + i] = null;

    }

    public void AtualizarContato(String nome, String numero ) {
        int i;
        //antes de tudo, verificar se o número existe
        for(i =0 ; i<TAMANHO_REAL ; i++ ) {
            if (lista_de_contatos[i].GetNumero().equals(numero)) {
                return;
            }
        }
        //agora sim atualizar, caso o número já não exista
        for(i=0 ; i<TAMANHO_REAL ; i++) {
            if (lista_de_contatos[i].Getnome().equals(nome) ) {
                lista_de_contatos[i].MudarNumero(numero);
                System.out.println("O contato " + nome +" foi atualizado");
                return;
            }
        }

        //else
        System.out.println("O contato em questão não existe");
    }

    public String Pesquisar(String nome) {
        int i;
        for(i=0 ; i< TAMANHO_REAL ; i++) {
            if (lista_de_contatos[i].Getnome().equals(nome)) {
                return lista_de_contatos[i].GetNumero();
            }
        }
        return null;
    }

    public void ExibirLista() {
        int i; 
        for(i=0 ; i<TAMANHO_REAL ; i++) {
            System.out.print( "Nome: " + lista_de_contatos[i].Getnome() + " | ");
            System.out.println( "Numero: " + lista_de_contatos[i].GetNumero());
        }
    }

}

