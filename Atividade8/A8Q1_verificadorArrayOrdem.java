

public class A8Q1_verificadorArrayOrdem {
    public static <T extends Comparable<T>> boolean estaOrdenado(T[] array) {
        
        //arrays nulos ou com menos de 1 elemento fogem da regra, mas vou considerar ordenados
        if (array == null || array.length <= 1) {
        }
        else {

           
            for (int i = 0; i < array.length - 1; i++) {
                
                //se o elemento for menor q o seguinte vai retornar negativo, então não está ordenado
                if (array[i].compareTo(array[i+1]) > 0) {
                    return false; 
                }
            }
        }
        //se caiu no if, ou caso tenha ido pro else e passou por todo o loop sem encerrar, é ordenado
        return true;
    }

    public static void main(String Args[]) {
        //Inteiros
        Integer[] numerosOrdenados = {1, 2, 3, 4, 5};
        Integer[] numerosDesordenados = {1, 2, 5, 3, 4};

        //Strings (ordem alfabetica)
        String[] nomesOrdenados = {"Breno", "Bruno", "Giovanny", "Kalil"};
        String[] nomesDesordenados = {"Giovanny", "Kalil", "Beatriz"};
        
        //Doubles (decimais)
        Double[] decimaisOrdenados = {1.1, 2.5, 3.14, 9.99};
        Double[] decimaisDesordenados = {3.5, 10.17, 3.14, 2.73};

        

        System.out.println(estaOrdenado(numerosOrdenados) ? "Array 1  ordenado" : "Array 1  desordenado");

        System.out.println(estaOrdenado(numerosDesordenados) ? "Array 2  ordenado" : "Array 2  desordenado");

        System.out.println(estaOrdenado(nomesOrdenados) ? "Array 3  ordenado" : "Array 3  desordenado");

        System.out.println(estaOrdenado(nomesDesordenados) ? "Array 4  ordenado" : "Array 4  desordenado");

        System.out.println(estaOrdenado(decimaisOrdenados) ? "Array 5  ordenado" : "Array 5  desordenado");

        System.out.println(estaOrdenado(decimaisDesordenados) ? "Array 6  ordenado" : "Array 6  desordenado");


    }
    
}

