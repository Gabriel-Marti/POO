//como a unica coisa que varia de fato é o aluno e a matricula, o construtor será baseado neles

class Aluno{
private String nome;
private String matricula;

public Aluno(String nome, String matricula) {
    this.nome = nome;
    this.matricula = matricula;


}

public String toString() {
    return String.format("Aluno: %s | Matrícula: %s", nome, matricula);
}

}


public class A4Q3_turmadealunos {
    private static final int TAMANHO_MAXIMO = 20; //tamanho maximo do array
    private Aluno[] listaTurma;
    private int quantidadePreenchida; //define a quantidade que realmente está preenchida no array

    static String Professor = "Giovanny";
    static String Disciplina = "POO";
    static String turma = "T01";

    public A4Q3_turmadealunos(){
        this.listaTurma = new Aluno[TAMANHO_MAXIMO];

        this.listaTurma[0] = new Aluno("Igor", "20250001");
        this.listaTurma[1] = new Aluno("Paulo", "20250002");
        this.listaTurma[2] = new Aluno("José", "20250003");

        this.quantidadePreenchida = 3;

    }

    public void AdicionarAluno(String nome, String matricula) {

        Aluno novoaAluno = new Aluno(nome, matricula);

        listaTurma[quantidadePreenchida] = novoaAluno;
        quantidadePreenchida++;
    }

    static void ExibirLista(Aluno[] lista, int quantidadePreenchida) {
        System.out.printf("Professor: %s\n", Professor);
        System.out.printf("Disciplina: %s\n", Disciplina);
        System.out.printf("Turma: %s\n", turma);

        if (quantidadePreenchida == 0) {
            System.out.println("Sem alunos para essa turma");
        } else {
            for (int i = 0 ; i < quantidadePreenchida ; i++) {
                System.out.println(lista[i]);
            }
        }
    }



    public static void main(String[] args) {
        A4Q3_turmadealunos gerenciador = new A4Q3_turmadealunos() ;

        gerenciador.ExibirLista(gerenciador.listaTurma, gerenciador.quantidadePreenchida);

        gerenciador.AdicionarAluno("Luiz", "20250004");
        //para formatar
        System.out.println(" ");
        //confirmar que funcionou
        gerenciador.ExibirLista(gerenciador.listaTurma, gerenciador.quantidadePreenchida);
    }

}
