import java.util.Arrays;

public class A8Q3_concatenadorArray {
    public static <T> T[] comcatenador (T[] array1, T[] array2) {
        
        int TamanhoTotal = array1.length + array2.length;

        T[] arrayComcatenado = Arrays.copyOf(array1, TamanhoTotal);

        //System.arraycopy(arrayAduplicar(origem), posicaoOrigem, destino, posicaoDestino, quantidadeDeElementos)

        System.arraycopy(array2, 0, arrayComcatenado, array1.length, array2.length);

        return arrayComcatenado;
    }

    public static void main(String[] args){
        //Inteiros
        Integer[] numerosOrdenados = {1, 2, 3, 4, 5};
        Integer[] numerosDesordenados = {1, 2, 5, 3, 4};

        //Strings (ordem alfabetica)
        String[] nomesOrdenados = {"Breno", "Bruno", "Giovanny", "Kalil"};
        String[] nomesDesordenados = {"Giovanny", "Kalil", "Beatriz"};
        
        //Doubles (decimais)
        Double[] decimaisOrdenados = {1.1, 2.5, 3.14, 9.99};
        Double[] decimaisDesordenados = {3.5, 10.17, 3.14, 2.73};

        System.out.println(Arrays.toString(comcatenador(numerosOrdenados, numerosDesordenados)));
        System.out.println(Arrays.toString(comcatenador(nomesOrdenados,nomesDesordenados)));
        System.out.println(Arrays.toString(comcatenador(decimaisOrdenados, decimaisDesordenados)));
        System.out.println(Arrays.toString(comcatenador(decimaisDesordenados, decimaisOrdenados)));
    }

}
