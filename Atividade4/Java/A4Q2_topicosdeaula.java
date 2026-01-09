//o main ta no final


//classe privada não principal, dedicada a gerar elementos da lista, cada tópico da aula
class TopicoAula {
 
    private String data; 
    private String titulo;
    private String assunto;

    public TopicoAula(String data, String titulo, String assunto) {
        this.data = data;
        this.titulo = titulo;
        this.assunto = assunto;
    }


    public String toString() {
        return String.format("%s | Título: %s | Assunto: %s", 
                             data, titulo, assunto);
    }
}

//classe principal, onde os objetos que compõe a lista serão gerenciados
public class A4Q2_topicosdeaula {

    // Como o enunciado disse que o sistema deve ser pequeno eu vou colocar um tamanho máximo grande
    //assim não será necessário se preocupar com estouro de limite 
     private static final int TAMANHO_MAXIMO = 20; 
    
    private TopicoAula[] listaTopicos;
    private int quantidadeTopicos; //rastreia quantos tópicos estão preenchidos

    public A4Q2_topicosdeaula() {
        this.listaTopicos = new TopicoAula[TAMANHO_MAXIMO];

        //3 elementos parece curto o bastante
        this.listaTopicos[0] = new TopicoAula("01/03/2026", "Revisão Java", "Tipos primitivos e controle de fluxo.");
        this.listaTopicos[1] = new TopicoAula("03/03/2026", "Conceitos de POO", "Encapsulamento e visibilidade.");
        this.listaTopicos[2] = new TopicoAula("05/03/2026", "Trabalhando com Arrays", "Criação, acesso e iteração.");
        
        this.quantidadeTopicos = 3;
        
        
    }

    public void adicionarTopico(String data, String titulo, String assunto) {
        

        //cria o objeto TopicoAula
        TopicoAula novoTopico = new TopicoAula(data, titulo, assunto);

        
        //adiciona o objeto ao array, não é preciso se preocupar com a posição contada a partir do 0
        //pois o numero de topicos por não partir do 0 vai fazer o novo tópico ir para uma posição
        //a mais que o último
        listaTopicos[quantidadeTopicos] = novoTopico;
        quantidadeTopicos++;
    }


    static void ExibirLista(TopicoAula[] lista, int quantidadePreenchida) {

  

        if (quantidadePreenchida == 0) {
            System.out.println("A lista está vazia");
        } else {
            for (int i = 0 ; i <quantidadePreenchida ; i++) {

            System.out.println(lista[i]);

        }

        }
     
        
    }


    public static void main(String[] args) {

        //instanciando um objeto que tenha os métodos a serem usados a partir da classe principal
        A4Q2_topicosdeaula gerenciador = new A4Q2_topicosdeaula();

    
        //exibindo conforme pedido
        gerenciador.ExibirLista(gerenciador.listaTopicos, gerenciador.quantidadeTopicos);

        //a funcionalidade que permite adicionar existe, conforme pedido
        gerenciador.adicionarTopico("17/11/2025", "For Loop", "Tópicos especiais em loop");

        //para formatar e ficar separado as duas exibições
        System.out.println(" ");

        //exibir para mostrar que de fato foi adicionado
        gerenciador.ExibirLista(gerenciador.listaTopicos, gerenciador.quantidadeTopicos);

    }

    

    
}
