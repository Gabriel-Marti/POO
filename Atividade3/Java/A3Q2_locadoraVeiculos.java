import java.util.Scanner;
/**A questão deixa bem claro que é uma diária, mas há um problema nisso, com somente os dados pedidos:
 * "como entrada a quantidade de dias e a quilometragem total rodada por um cliente dessa locadora"
 * não é possível determinar com precisão o preço a ser pago, pois para isso seria necessário
 * saber também o número de quilometragem percorrida por dia, nesse caso, com as informações
 * da questão é possível fazer um cálculo aproximado, considerando que em todos os dias 
 * a cota de 100km foi batida, considera a quilpmetragem total e pegar a diferença do limite 
 * baseado no número de dias, mas tem um erro aí, pois se por exemplo houvessem 3 dias,
 * onde a quilometragem foi respectivamente 10, 10 e 280 deveria ser cobrado a mais no terceiro dia
 * mas com as informações inseridas, por não ser possível saber quanto foi gasto por dia será suposto
 * que a divisão de quilometragem foi feita de forma igualmente proporcional, com a cota sendo 300
 * ou seja o limite de 3 dias e então nada seria pago, também não pode ser cumulativo, pois a questão
 * informa que é uma DIÁRIA, ou seja se é diário não é possóvel pagar 1 dia para andar 5km em 20 dias,
 * sendo algo diário a cota de quilometragem expira caso não seja usada
 * 
*/


public class A3Q2_locadoraVeiculos {

    public static void main() {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Insira o número de dias");
        int dias = Scanner.nextInt();
        //A frase "R$ 12 para cada quilômetro a mais" é ambígua. 
        //Ela pode indicar que será 12 reais para cada unidade inteira de quilometro a mais
        //de modo que não existiria taxa "quebrada" como um 6 reais para 0,5km
        //ou que será uma taxa contínua em que 12 reais é proporcional a 1km
        //mas o enunciado pede para dar a resposta em 2 casas decimais.
        //Dando a entender que é uma taxa proporcional
        System.out.println("Insira a quilometragem total percorrida");
        double quilometragem = Scanner.nextDouble();

        double cota_maxima = dias*100;

        double Extra = quilometragem - cota_maxima;

        double preco = dias*90 + Extra*12;

        /*Nota:
            %d = Espaço reservado para um int (inteiro)

            %.2f = Espaço reservado para um double ou float (com 2 casas decimais)

            %s = Espaço reservado para uma String (texto)

            \n = Comando para pular uma linha
         */

        System.out.printf("O valor a ser pago é: R$ %.2f", preco);

    }


}
