public class A3Q7_minimercado {
    
    public static void main(String[] Args) {

        int quantidade_garrafasDeVinho = Integer.parseInt(IO.readln("Insira quantas garrafas comprará:"));
        int precoGarrafas = 25;
        double pesoPao = Double.parseDouble(IO.readln("Insira quantos quilos comprará"));
        double precoPao = 4.5;
        double LitrosLeite = Double.parseDouble(IO.readln("Insira quanto litros de leite comprará"));
        double precoLitrodeLeite = 5.3;

        double PrecoLeite_TotalsemDesconto = LitrosLeite*precoLitrodeLeite;
        double PrecoPao_TotalsemDesconto = pesoPao*precoPao;
        double PrecoVinho_TotalsemDesconto = quantidade_garrafasDeVinho*precoGarrafas;
        double PrecoTotalLeiteReal = DescontoLeite(LitrosLeite, precoLitrodeLeite);
        double PrecoTotalPaoReal = DescontoPao(pesoPao, precoPao);
        double PrecoTotalVinhoReal = DescontoVinho(quantidade_garrafasDeVinho, precoGarrafas);
        double ValorTotal = PrecoTotalLeiteReal + PrecoTotalPaoReal + PrecoTotalVinhoReal;

        double descontoLeite = PrecoLeite_TotalsemDesconto - PrecoTotalLeiteReal;
        double descontoPao = PrecoPao_TotalsemDesconto - PrecoTotalPaoReal;
        double descontoVinho = PrecoVinho_TotalsemDesconto - PrecoTotalVinhoReal;


        if (PrecoPao_TotalsemDesconto != 0) {
            System.out.printf("Pão --------------------- R$ %.2f\n", PrecoPao_TotalsemDesconto);
        }
        if (descontoPao != 0) {
            System.out.printf("Desconto no pão ------- R$-%.2f\n", descontoPao);
        }
        if (PrecoLeite_TotalsemDesconto != 0) {
            System.out.printf("Leite ------------------- R$ %.2f\n", PrecoLeite_TotalsemDesconto);
        }
        if (descontoLeite != 0) {
            System.out.printf("Desconto no leite ------- R$-%.2f\n", descontoLeite);
        }
        if (PrecoVinho_TotalsemDesconto != 0) {
            System.out.printf("Vinho ------------------- R$ %.2f\n", PrecoVinho_TotalsemDesconto);
        }
        if (descontoVinho != 0) {
            System.out.printf("Desconto no vinho ------- R$-%.2f\n", descontoVinho);
        }
        if (ValorTotal != 0) {
            System.out.printf("Valor Total ------------- R$ %.2f\n", ValorTotal);            
        }
        
        
    }


    static double DescontoPao(double peso, double preco) {
        if (peso >= 1) {
            return (peso*preco) * 0.95;
        } else { return peso * preco; }
    }


    //calcula o valor sem desconto e subtrai do desconto aplicado a cada terceiro litro
    static double DescontoLeite(double litros, double preco) {
       double precoSemdesconto = litros * preco;
       int LitrosComDesconto = (int) (litros/3); //o desconto é aplicado a cada terceiro litro inteiro
       double precototalleite = precoSemdesconto - LitrosComDesconto*preco*0.1;
       
       return precototalleite;
    }

    //a cada 3 garrafas de vinho a segunda sair gratis, então dividir em partes de 3
    //dessas partes de 3 considerar apenas duas de cada parte e adicionar o resto não divisível
    //então o preço de uma das 3 garrafas será desconsiderado
    //por comutatividade não importa se é a segunda, a terceira ou a primeira a sair grátis
    static double DescontoVinho(int quantidade, double preco) {
            double valorSemDesconto = quantidade*preco;
            int novaquantidade = 2*(quantidade/3) + quantidade%3;

            double precoTotal = novaquantidade * preco;

            return precoTotal;
        }
}
