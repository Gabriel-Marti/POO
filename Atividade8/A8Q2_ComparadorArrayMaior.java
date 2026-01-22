public class A8Q2_ComparadorArrayMaior {
    public static <T extends Comparable<T>> T Maior(T[] array) {
        T MaiorElemento = array[0]; //começa definindo o primeiro como maior
        int i;
        for (i=1 ; i<array.length ; i++) {
            //se o seguinte for maior vai substituindo, começa de 1, pois o 0 é o maior padrão
            if(array[i].compareTo(MaiorElemento) > 0) {
                MaiorElemento = array[i];
            }
        }
        return MaiorElemento;
    }

    public static void main(String Args[]) {
        //Inteiros
        Integer[] numeros = {1, 2, 5, 3, 4};

        //Strings (ordem alfabetica)
        String[] nomes = {"Breno", "Bruno", "Giovanny", "Kalil"};
        
        //Doubles (decimais)
        Double[] decimais = {3.5, 10.17, 3.14, 2.73};

        System.out.println(Maior(numeros));
        System.out.println(Maior(nomes));
        System.out.println(Maior(decimais));
    }

}
