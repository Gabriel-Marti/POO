import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

//classe abstrata que serve como classe raiz para todas as demais classes derivadas de funcionários
public abstract class A7Q3_funcionarios {
    protected String Nome;
    protected String CPF;

    protected int anoNascimento;
    protected int mesNascimento;
    protected int diaNascimento;
    protected int Idade;
    //definição da data de nascimento com LocalDate

    protected LocalDate DataDeNascimento;
    protected LocalDate DataAtual = LocalDate.now(); //pega a data atual

//método abstrato para clacular pagamento dos funcionários, será reaproveitado em subclasses futuras

    protected void CalcularIdade() {
        Idade = (Period.between(DataDeNascimento, DataAtual)).getYears();
    }

    public int GetIdade() {
        return Idade;
    }


}

//Classe de terceirizados, sem método para calcular pagamento
class Terceirizados extends A7Q3_funcionarios {
    private String dependencia = "Sem dependencia" ; //incialmente começa sem estar alocado a nada

    public Terceirizados(String nome, String CPF, int ano, int mes, int dia) {
        this.Nome = nome;
        this.CPF = CPF;
        this.anoNascimento = ano;
        this.mesNascimento = mes;
        this.diaNascimento = dia;
        DataDeNascimento = LocalDate.of(anoNascimento,mesNascimento, diaNascimento);
        CalcularIdade();
    }

    //é alocado a uma dependência posteriormente, com esse método
    public void AlocarDependencia(String NovaDependencia) {
        dependencia = NovaDependencia;
    }

    public String getDependencia() {
        return dependencia;
    }

}

//Como o pagamento só é realizado a tecnicos-admnistrativos e docentes
//então não fucnioanrai crair um método abstrato CalcularPagamento na classe raiz
//assim será criada uma subclasse para funcioanrios internos, que será base para não terceirizados
//NOTA: os niveis de prestígio são uma abstraçaõ simples e simbólica de fatores de aumento
//por isso apesar de poderem parecer semelhantes, representam coisas diferetnes para cada classe
//assim não devem ser definidos na herança
abstract class FuncionarioInterno extends A7Q3_funcionarios{
    protected abstract void CalcularPagamento();
    protected double Salario;

    public double GetSalario() {
        return Salario;
    } 

}

//CLASSE DE TECNICO-ADMNISTRATIVOS
class TecnicoAdmnistrativo extends FuncionarioInterno {
    private double SalarioBaseAdmnistrativo = 5.99 ; //salario base ficticio por exemplo para tecnico admnistrativo
    private int nivelCapacitacao; //nivel de prestigio para calcular salario, algo inventado só para exemplo

    public TecnicoAdmnistrativo(String nome, String CPF, int ano, int mes, int dia, int nivelCapacitacao) {
        this.Nome = nome;
        this.CPF = CPF;
        this.anoNascimento = ano;
        this.mesNascimento = mes;
        this.diaNascimento = dia;
        this.nivelCapacitacao = nivelCapacitacao;
        DataDeNascimento = LocalDate.of(anoNascimento,mesNascimento, diaNascimento);
        CalcularIdade();
        CalcularPagamento();
    }

    //calcula o pagamento baseado no metodo que eu defini
    protected void CalcularPagamento() {
        //o método escolhido para calcular pagamento é o salario base, com bonus baseado no prestigio
        //o prestigio é um inteiro e o bonus é aplicado como 10% a mais para cada nivel de prestigio
        Salario = SalarioBaseAdmnistrativo*(1+ nivelCapacitacao*0.1);
    }
}

//Classe de docente que serve como base apra herança das variações possíveis de docentes
//como existem diferentes tipos de docentes, então o cálculo de salário será diferente para cada
abstract class Docente extends FuncionarioInterno {
    //A alocação de disciplinas a um docente será feita por array de strings
    //para fins de exemplo, defini o numero máximo de disciplinas que um docente pode pegar como 5
    //esse será o tamanho máximo do array
    //cada string num array terá o nome de uma disciplina que o docente venha a pegar
    private static final int DISCIPLINAS_MAXIMAS = 5;
    private ArrayList<String> disciplinas = new ArrayList<>() ;
    //private int NumeroAtualDisciplinas = 0 ; //começa com 0 disciplinas alocadas
    
    //Aloca docente à disciplina, falha se tiver batido o limite
    public void AlocarDisciplina(String disciplina) {
        if (disciplinas.size() < DISCIPLINAS_MAXIMAS) {
            this.disciplinas.add(disciplina);
        } else {
            System.out.println("Não foi possível alocar, limite máximo atingido");
        }
    }

    public void RemoverDisciplina(String disciplina) {
        //executa a remoção dentro da condicional, se falhar retorna erro
        if (!(this.disciplinas.remove(disciplina))) {
            System.out.print("O docente não está alocado para essa disciplina");
        }
    }

    public void listarDisciplinas() {
        if (this.disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina alocada para este professor.");
        } else {
            System.out.println("Disciplinas alocadas para " + this.Nome + ": " + this.disciplinas);
        }
    }

}

//CLASSE REFERENTE A DOCENTES DE DEDICAÇÃO EXCLUSIVA
class DocenteExclusivo extends Docente {
    private double SalarioBaseDocenteExclusivo = 25.99 ;
    private int titulacao;

    public DocenteExclusivo(String nome, String CPF, int ano, int mes, int dia, int titulacao) {
        this.Nome = nome;
        this.CPF = CPF;
        this.anoNascimento = ano;
        this.mesNascimento = mes;
        this.diaNascimento = dia;
        this.titulacao = titulacao;
        DataDeNascimento = LocalDate.of(anoNascimento,mesNascimento, diaNascimento);
        CalcularIdade();
        CalcularPagamento();
    }

    //apesar do calculo ser análogo no exemplo, ele poderia ser diferente
    //devido à possíveis variações para cada funcionário, foi usado o polimorfismo
    protected void CalcularPagamento(){
        Salario = SalarioBaseDocenteExclusivo*(1+ titulacao*0.1);
    }
}

//CLASSE REFERENTE A DOCENTES DE TEMPO PARCIAL
class DocenteTempoParcial extends Docente {
    private double SalarioBaseDocenteTempoParcial = 15.99 ;
    private int tempoExperiencia;

    public DocenteTempoParcial(String nome, String CPF, int ano, int mes, int dia, int tempoExperiencia) {
        this.Nome = nome;
        this.CPF = CPF;
        this.anoNascimento = ano;
        this.mesNascimento = mes;
        this.diaNascimento = dia;
        this.tempoExperiencia = tempoExperiencia;
        DataDeNascimento = LocalDate.of(anoNascimento,mesNascimento, diaNascimento);
        CalcularIdade();
        CalcularPagamento();
    }

    //apesar do calculo ser análogo no exemplo, ele poderia ser diferente
    //devido à possíveis variações para cada funcionário, foi usado o polimorfismo
    protected void CalcularPagamento(){
        Salario = SalarioBaseDocenteTempoParcial*(1+ tempoExperiencia*0.1);
    }
}

//CLASSE PARA DOCENTES SUBSTITUTOS
//eu poderia fazer uma superclasse de substitutos para então derivar classes de 40h e 20h semanais
//entretanto é mais simples simplesmente colocar um atributo horas semanais para definir a categoria
//baseando-se no número de horas semanais, o salário muda
class DocenteSubstituto extends Docente {
    private int Horas_semanais;
    private double SalarioBaseDocenteSubstituto40h = 20.99 ;
    private double SalarioBaseDocenteSubstituto20h = 10.99 ;
    private int prestigio;

    public DocenteSubstituto(String nome, String CPF, int ano, int mes, int dia, int prestigio, int Horas) {
        this.Horas_semanais = Horas;
        this.Nome = nome;
        this.CPF = CPF;
        this.anoNascimento = ano;
        this.mesNascimento = mes;
        this.diaNascimento = dia;
        this.prestigio = prestigio;
        DataDeNascimento = LocalDate.of(anoNascimento,mesNascimento, diaNascimento);
        CalcularIdade();
        CalcularPagamento();
    }

    //o cálculo de salário agora é diferente, ele varia dependendo do número de horas de trabalho
    //pois eventualmente os que tem mais horas tem salário base maior, variando com promoções
    protected void CalcularPagamento(){
        if (Horas_semanais == 40) {
            Salario = SalarioBaseDocenteSubstituto40h*(1+ prestigio*0.1);
        } else if (Horas_semanais == 20) {
            Salario = SalarioBaseDocenteSubstituto20h*(1+ prestigio*0.1);
        }
    }
}
