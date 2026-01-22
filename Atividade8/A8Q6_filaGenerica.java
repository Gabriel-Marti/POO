//copiei e colei o código original implementar a funcionalidade pedida

import java.util.Arrays;

public class  A8Q1_filaGenerica <T> {
    


    //a fila é cíclica e os elementos são de um tipo genérico T
    private T[] elementos;
    private int tamanho;
    private int inicio; //indice que determina inicio do ciclo
    private int fim; //indice que determina fim do ciclo
    private int CAPACIDADE;

    public A8Q1_filaGenerica(int capacidade) {
        this.CAPACIDADE = capacidade;
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = 0;
        //criar um array de objetos (todos os tipos primitivos são objetos em java) 
        //para permitir generalidade converte para o genético T
        this.elementos = (T[]) new Object[CAPACIDADE];
    }
    public boolean vazia() {
        return tamanho == 0;
    }
    public boolean cheia() {
        return tamanho == CAPACIDADE;
    }

    public int tamanho() {
        return tamanho;
    }
    public T primeiro() {
        if (tamanho > 0)
            return elementos[inicio];
        else {
            System.out.println("Pegando o primeiro de fila vazia");
            System.exit(1);
            return null;
        }
    }
    

    //método pedido na questão 6 da atividade antiga para tornar a fila sem limite
    private T[] AumentarCapacidade(T[] fila) {

        //vou aumentar ela baseado na demanda, poderia ser dobrando, triplicando, somando em 2
        //somando em n, multiplicando por n, mas para simplificar vou aumentar de 1 em 1 mesmo
        T[] Nova_fila = (T[]) new Object[CAPACIDADE + 1];
        //é preciso realinhar a lista, pois se apenas adicionar +1 com ela bagunçada vai quebrar
        //com espaços vazios entre a fila, mas realinhado é possível garantir q o vazio fique no final 
        int i;
        //como começa contando de 0 deve ser i<capacidade para o tamanho ficar correto
        for (i=0 ; i < CAPACIDADE ; i++) {
            Nova_fila[i] = fila[(inicio + i) % CAPACIDADE] ; //como i começa com 0, vai seguindo a fila
        }

        this.inicio = 0; //o inicio fica definido como indíce 0, ujá que a fila foi realinhada 
        this.fim = CAPACIDADE; //como começa de 0 a posição referente ao limita estará vazia
        this.CAPACIDADE++; 
        //atribui a varíavel referente à fila antiga para apontar à nova fila
        //é como se a fila fosse transformada para uma maior
        this.elementos = Nova_fila;
        //retorna a fila, com capacidade aumentada
        return fila;
    }


    public void enfilerar(T elem) {
        if (tamanho < CAPACIDADE) {
            elementos[fim] = elem;
            fim = (fim+1)%CAPACIDADE;
            tamanho++;
        } else {
            //agora, se a contagem passar do limite de capacidade não vai mais dar erro
            //chamará o método para aumentar a capacidade
            AumentarCapacidade(elementos);
            //então é só chamar a função de novo, como a capacidade aumentou não vai cair no else
            //o programa enfileira corretamente e aumenta o limite da fila
            enfilerar(elem);
        }
    }

    public T desenfilerar() {
        if (tamanho > 0) {
            T primeiro = elementos[inicio];
            inicio = (inicio+1)%CAPACIDADE;
            tamanho--;
            return primeiro;
        } else {
            System.out.println("Tirando de fila vazia");
            System.exit(1);
            return null;
        }
    }

    //NOTA: A QUESTÃO NÃO PEDIU ESPECIFICAMENTE QUE CADA ARRAY SÓ ACEITASSE UM TIPO
    //assim, para não precisar adicionar restrição nem fazer vários testes repetitivos
    //adicionei multiplos tipos no array fila, isso prova que a fila é genérica e o código funciona
    public static void main(String[] args) {
        //instanciando um novo objeto a partir do construtor
        //usando o raw type mesmo, uma vez que o objetivo é apenas teste
        A8Q1_filaGenerica Teste = new A8Q1_filaGenerica(5);
        //enfileirar varios 1 para teste
        Teste.enfilerar(1);
        Teste.enfilerar("olá");
        Teste.enfilerar("oi");
        Teste.enfilerar(3.14);
        Teste.enfilerar(0.5);
        //aqui estouraria o limite
        System.out.println(Arrays.toString(Teste.elementos));
        //"GIOVANNY" para ficar diferente e destacar
        Teste.enfilerar("GIOVANNY");
        System.out.println(Arrays.toString(Teste.elementos));
        //o resultado é satisfatório, o array aumenta e exibe o que eu mandei acrescentar
        //daria para fazer isso n vezes para n valores, o programa funciona
    }

}
