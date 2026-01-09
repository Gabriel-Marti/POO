import java.util.Scanner;

//como a questão só pediu para testar os métodos vou definir variáveis padrão, apenas para teste
//o teste será baseado nos métodos principais que a questão anterior pediu para serem feitas
public class A7Q4_TesteFuncionarios {
    //por ser um programa meramente de teste no main, visibilidade não é o foco aqui, da para ignorar 
    public static void main(String[] args) {

        //Os funcionários ficaram num lista de objetos funcionarios
        int NumeroFuncionarios = 5;
        A7Q3_funcionarios[] listaDeFuncionarios = new A7Q3_funcionarios[NumeroFuncionarios];

        Terceirizados tercerizado = new Terceirizados("Julio", "111.111.111-11", 2001, 12, 5);

        FuncionarioInterno TecnicoAdmnistrativo = new TecnicoAdmnistrativo("Maruim", "222.222.222-22", 2002, 1, 29, 2);

        Docente docenteExclusivo = new DocenteExclusivo("Giovanny Lucero", "123.456.789-09", 2000, 10, 10, 5);

        Docente docenteTP = new DocenteTempoParcial("Kalil Bispo", "000.000.001-91", 1900, 10, 7, 4);

        Docente docenteSubstituto = new DocenteSubstituto("José Osmário", "000.000.000-00", 2010, 6, 1, 1, 20);

        //colocar os funcionários na lista
        listaDeFuncionarios[0] = tercerizado;
        listaDeFuncionarios[1] = TecnicoAdmnistrativo;
        listaDeFuncionarios[2] = docenteExclusivo;
        listaDeFuncionarios[3] = docenteTP;
        listaDeFuncionarios[4] = docenteSubstituto;

        //testando alocar disciplinas para docenteExclusivo, análogo para outros docentes por herança
        //inicialmente vazio
        System.out.print("Disciplinas para Giovanny: ");
        docenteExclusivo.listarDisciplinas();
        System.out.print("Disciplinas para Kalil: ");
        docenteTP.listarDisciplinas();
        System.out.print("Disciplinas para Osmário: ");
        docenteSubstituto.listarDisciplinas();

        System.out.println(" ");
        System.out.println("Adicionando disciplinas ");
        System.out.println(" ");

        docenteExclusivo.AlocarDisciplina("poo");
        docenteExclusivo.AlocarDisciplina("pf");
        docenteExclusivo.AlocarDisciplina("Estrutura de dados");
        docenteTP.AlocarDisciplina("pi");
        docenteSubstituto.AlocarDisciplina("Metodos e tecnicas de pesquisa em computacao");

        docenteExclusivo.listarDisciplinas();
        docenteTP.listarDisciplinas();
        docenteSubstituto.listarDisciplinas();

        System.out.println(" ");

        //testando remover disciplinas
        System.out.println("Removendo disciplinas");
        docenteExclusivo.RemoverDisciplina("Estrutura de dados");
        docenteExclusivo.listarDisciplinas();

        System.out.println(" ");

        //Testando alocar dependencia para terceirizado
        System.out.print("Dependencia de " + tercerizado.Nome + ": " );
        System.out.println(tercerizado.getDependencia());
        System.out.println("Alocando dependencia para terceirizado ");
        tercerizado.AlocarDependencia("Didática IV");
        System.out.print("Dependencia de " + tercerizado.Nome + ": " );
        System.out.println(tercerizado.getDependencia());

        System.out.println(" ");

        //Testando calcular pagamento para os funcionários
        //Nota: devido à filosofia do poo, onde objetos devem nascer completos
        //o salário é um atributo dos funcionarios internos, definido no construtor das classes
        //assim testar ele diretamente seria redundante, então o foco é imprimir o atributo
        //o atributo já estava definido desde a instanciação, mas vou ativar o método por garantia
        System.out.println("Calculando pagamento dos funcionários");
        int i;
        for(i=0; i<NumeroFuncionarios ; i++) {
            //o método calcular pagamento só é válido se o funcionário não for tercerizado
            //ou seja, é preciso verificar se é um funcionário interno
            if (listaDeFuncionarios[i] instanceof FuncionarioInterno ) {
                //caso seja funcionario interno, fazer especialização e avançar o nível de classe
                FuncionarioInterno funcionario = (FuncionarioInterno) listaDeFuncionarios[i];
                //após a especialização, é possível calcular o pagamento
                funcionario.CalcularPagamento();
                System.out.println("Salário de " + funcionario.Nome + ": " + funcionario.Salario );
            }
        }

        System.out.println(" ");

        //Provando que a idade é calculada corretamente, baseada nos valores inseridos
        System.out.println("Calculando idade dos funcionários ");
        for(i=0; i<NumeroFuncionarios; i++) {
            System.out.println(listaDeFuncionarios[i].GetIdade());
        }

    }
}
