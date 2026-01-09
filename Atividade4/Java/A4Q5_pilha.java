public class A4Q5_pilha {


    private static final int TAMANHO_MAXIMO = 5;
    private int quantidadePreenchida;
    //como a pilha pode ser feita de qualquer coisa, vou empilhar strings
    private String[] pilha;

    public static void main(String[] args) {
        A4Q5_pilha gerenciador = new A4Q5_pilha();
        //como não foi pedido nenhuma execução em específico, não há nada de especial no main
        //o resto do código por si só já faz uma operação com a ideia de uma pilha
        //incrementei e decrementei a "quantidadePreenchida" conforme fui empilhando e desempilhando
        //para ter um bom guia de onde empilhar/desempilhar
        gerenciador.Empilhar();
        gerenciador.Desempilhar();
    }

    
    public A4Q5_pilha() {
        this.pilha = new String[TAMANHO_MAXIMO];
        pilha[0] = "A";
        pilha[1] = "A";

        quantidadePreenchida = 2;
    }



    void Empilhar() {
        if (quantidadePreenchida < TAMANHO_MAXIMO) {
            pilha[quantidadePreenchida] = "A";
            quantidadePreenchida++;       
        } else { System.out.println("Capacidade máxima preenchida, não é possível mais empilhar");
                                    System.exit(0);
                }
                }

                

    void Desempilhar() {
        if (quantidadePreenchida > 0) {
            pilha[quantidadePreenchida - 1] = null; //deixa vazio o lugar do elemento
            quantidadePreenchida-- ;
        } else { System.out.println("Não é possível desempilhar uma pilha vazia"); }
        
    }

    

}
