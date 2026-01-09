
//copiei e colei o código original no slide para implementar a funcionalidade pedida

import java.util.Arrays;

public class A5Q6_fila {
    // O elementos também para de ser final, agora o array pode ser alterado
    //assim é possível reatribuir ele para uma novo array com mais capacidade.
    private int[] elementos;
    private int tamanho;
    private int inicio;
    private int fim;
    //CAPACIDADE para de ser final, agora pode ser alterada
    private int CAPACIDADE;

    public A5Q6_fila(int capacidade) {
        this.CAPACIDADE = capacidade;
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = 0;
        this.elementos = new int[CAPACIDADE];
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
    public int primeiro() {
        if (tamanho > 0)
            return elementos[inicio];
        else {
            System.out.println("Pegando o primeiro de fila vazia");
            System.exit(1);
            return 0;
        }
    }
    
    //a implementação realmente nova, pedida no enunciado
    public int[] AumentarCapacidade(int[] fila) {
        //como o exercício apnas pediu para que a capacidade fique sem limites
        //vou aumentar ela baseado na demanda, poderia ser dobrando, triplicando, somando em 2
        //somando em n, multiplicando por n, mas para simplificar vou aumentar de 1 em 1 mesmo
        int[] Nova_fila = new int[CAPACIDADE + 1];
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


    public void enfilerar(int elem) {
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

    public int desenfilerar() {
        if (tamanho > 0) {
            int primeiro = elementos[inicio];
            inicio = (inicio+1)%CAPACIDADE;
            tamanho--;
            return primeiro;
        } else {
            System.out.println("Tirando de fila vazia");
            System.exit(1);
            return 0;
        }
    }

    //apesar do código original não ter main, fiz um só para testar
    public static void main(String[] args) {
        //instanciando um novo objeto a partir do construtor
        A5Q6_fila Teste = new A5Q6_fila(5);
        //enfileirar varios 1 para teste
        Teste.enfilerar(1);
        Teste.enfilerar(1);
        Teste.enfilerar(1);
        Teste.enfilerar(1);
        Teste.enfilerar(1);
        //aqui estouraria o limite
        System.out.println(Arrays.toString(Teste.elementos));
        //2 para ficar diferente e destacar
        Teste.enfilerar(2);
        System.out.println(Arrays.toString(Teste.elementos));
        //o resultado é satisfatório, o array aumenta e exibe o que eu mandei acrescentar
        //daria para fazer isso n vezes para n valores, o programa funciona
    }
}
