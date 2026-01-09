//como a questão falou para não usar nenhuma biblioteca, assumi que não posso usar o scanner também
//então usei o IO mesmo
//A partir das informações inseridas eu calculei quantos dias faltam para o são joão calculando
//qual nº do ano foi inserido e qual a posição do dia do são joão em relação ao ano
//a partir disso, caso o dia "atual" seja anterior ao São João para saber quantos dias faltam
//basta subtrair a posição do dia do são joão no ano pela posição do dia "atual" no ano
//caso tenha passado do são joão terá que esperar passar o ano "atual" para chegar ao são joão seguinte
//então é preciso considerar os dias restantes para acabar o ano e em qual nº do ano
//estará o próximo são joão, considerando as variações de bissexto ou não


public class A3Q5_saojoao {



    
    public static void main(String[] Args){

        int dia = Integer.parseInt(IO.readln("Insira o dia"));
        int mes = Integer.parseInt(IO.readln("Insira o mes"));
        int ano = Integer.parseInt(IO.readln("Insira o ano"));
        boolean bissexto = verificarBissexto(ano);
        int total_dias;
        int diasParaOSaoJoao;

        //decubrir qual nº dia do ano foi inserido
        total_dias = contarDias(bissexto, dia, mes);

        //calcular quantos dias faltam baseado nas posições dos dias em relação ao ano
        diasParaOSaoJoao = QuantosDiasFaltam(bissexto, total_dias, ano);

        System.out.printf("Faltam %d dias para o São João", diasParaOSaoJoao);

    }


    static boolean verificarBissexto(int ano) {
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 ==0 ){
            return true;
        } else { return false; }
    }


    //A ideia aqui é verificar em qual dia do ano está exatamente
    //Por exemplo: Está no 89º dia do ano, enquanto o sao joao é o 175º ou 176º
    //a posição do dia em relação ao ano será dada pelo:
    //dia do mes + total de dias dos meses anteriores
    static int contarDias(boolean bissexto, int dia, int mes) {
        int TotaldeDias;
        int DiasFevereiro;

        if (bissexto == true) {
            DiasFevereiro = 29;
        } else {DiasFevereiro = 28; }

        switch (mes) {
            case 1: //janeiro (31 dias)
            TotaldeDias = dia;
                break;
            case 2: //fevereiro (28 ou 29 dias)
            TotaldeDias = 31 + dia;
                break;
            case 3: //março (31 dias)
            TotaldeDias = 31 + DiasFevereiro + dia;
                break;
            case 4: //abril (30 dias)
            TotaldeDias = 62 + DiasFevereiro + dia;
                break;
            case 5: //maio (31 dias)
            TotaldeDias = 92 + DiasFevereiro + dia;
                break;
            case 6: //junho (30 dias)
            TotaldeDias = 123 + DiasFevereiro + dia;
                break;
            case 7: //julho (31 dias)
            TotaldeDias = 153 + DiasFevereiro + dia;
                break;
            case 8: //agosto (31 dias)
            TotaldeDias = 184 + DiasFevereiro + dia;
                break;
            case 9: //Setembro (30 dias)
            TotaldeDias = 215 + DiasFevereiro + dia;
                break;
            case 10: //Outubro (31 dias)
            TotaldeDias = 245 + DiasFevereiro + dia;
                break;
            case 11: //Novembro (30 dias)
            TotaldeDias = 276 + DiasFevereiro + dia;
                break;
            case 12: //Dezembro (31 dias)
            TotaldeDias = 306 + DiasFevereiro + dia;
                break;
            default:
            TotaldeDias = 0;
            System.out.println("Mês inválido");
                break;
        }

        return TotaldeDias;

    }


    //baseado em qual Xº dia do ano foi inserido será calculado quantos dias faltam para o São João
    //nesse caso será preciso descubrir qual a posição do dia do São João em relação ao ano
    //qual a posição do dia inserido em relação ao ano
    //Qual a posição do São João seguinte em relação ao ano seguinte, então se ambos são bissextos
    static int QuantosDiasFaltam(boolean bissexto, int total, int ano) {
        int DiaSaoJoao;
        int DiasRestantes;
        int DiasAno;
        int SaoJoaoSeguinte;

      
        if (bissexto==true) {
            DiasAno = 366;
        } else {DiasAno = 365;}

        if (bissexto == true) {
            DiaSaoJoao = 176; // Será o 176º dia do ano
        } else {DiaSaoJoao = 175; } //Será o 175º dia do ano

        //descubrir se ano seguinte é bissexto para saber quantos dias faltarão para o são joao seguinte
          if (verificarBissexto(ano + 1) == true) { 
            SaoJoaoSeguinte = 176;
        } else { SaoJoaoSeguinte = 175;} //se nao for bissexto será o 175º do ano seguinte

        
        DiasRestantes = DiaSaoJoao - total;
        
        /**Se já tiver passado do São João a subtração vai ser negativa
         * Sendo esse o caso, como passou do dia, então os dias restantes serão calculados pela
         * quantia de dias restantes para acabar o ano + dia do sao joao seguinte 
         */
        if (DiasRestantes < 0) {
            DiasRestantes = DiasAno - total + SaoJoaoSeguinte; }
        

        return DiasRestantes; 

    }

    
} 
