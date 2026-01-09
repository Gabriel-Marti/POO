// Fiz essa baseado no código da pilha da questão anterior
//por simplicidade, se houver algum erro o programa será encerrado.
//o main ta no final e ele ta sendo usado para executar o exemplo do enunciado
// e testar se funciona.


public class A4Q6_Calculadora {
    
    //aumentei a capacidade em comparação à pilha da questão anterior porque 5 era pequeno demais.
    private static final int TAMANHO_MAXIMO = 100; 
    
    private int quantidadePreenchida;
    private double[] pilha; 


    public A4Q6_Calculadora() {
        this.pilha = new double[TAMANHO_MAXIMO];
        this.quantidadePreenchida = 0;
    }

    //métodos de pilha


    public void push(double numero) {
        if (quantidadePreenchida < TAMANHO_MAXIMO) {
            pilha[quantidadePreenchida] = numero;
            quantidadePreenchida++;
        } else { 
            System.out.println("Pilha cheia, capacidade máxima de " + TAMANHO_MAXIMO + " atingida. Programa encerrado");
            System.exit(0);
        }
    }
    
    
     //desempilha e retorna o número do topo(LIFO)

    private double pop() {
        if (quantidadePreenchida > 0) {
            quantidadePreenchida--;
            double resultado = this.pilha[quantidadePreenchida];
            this.pilha[quantidadePreenchida] = 0; //limpa
            return resultado;
        } else { 
            System.out.println("Pilha vazia, programa encerrado");
            System.exit(0);
            return 0; 
        }
    }
    
    //lógica de operação
    
    private void executarOperacao(String operador) {
        if (quantidadePreenchida < 2) {
            System.out.println("oeração '" + operador + "' requer 2 operandos");
            System.exit(0);
        }
        
        // Desempilha os dois operandos na ordem correta (LIFO)
        double operando2 = pop(); 
        double operando1 = pop(); 
        double resultado;

        switch (operador) {
            case "+": resultado = operando1 + operando2; break;
            case "-": resultado = operando1 - operando2; break;
            case "*": resultado = operando1 * operando2; break;
            case "/": 
                if (operando2 == 0) {
                    System.out.println("Não é possível dividir por 0");
                    System.exit(0);
                }
                resultado = operando1 / operando2; 
                break;
            default:
                System.out.println("erro: Operador desconhecido");
                System.exit(0);
                return;
        }
        
        //coloca o resultado de volta na pilha
        push(resultado);
    }

    //   Métodos de operador:

    public void soma() { executarOperacao("+"); }
    public void subtracao() { executarOperacao("-"); }
    public void multiplicacao() { executarOperacao("*"); }
    public void divisao() { executarOperacao("/"); }


    //Retornar resultado(etapa final)
    
    

    //retorna o resultado final, verificando se a pilha tem um único elemento
    public double retornarResultado() {
        if (quantidadePreenchida != 1) {
            System.out.println("Não há um resultado final,os itens restantes são: " + quantidadePreenchida);
            System.exit(0);
        }
        // Desempilha o resultado final e o retorna
        return pop(); 
    }

    //como nenhuma execução em específico foi pedida eu usei o main apenas para testar se funciona
    //usando como teste o exemplo da questão anterior:  
    // (2+3)*(8-5) -> 2 3 + 8 5 - * ) 
    public static void main(String[] args) {
        
        A4Q6_Calculadora calc = new A4Q6_Calculadora();

        System.out.println("(2+3)*(8-5) | NPR: 2 3 + 8 5 - *");
        
        // 1-empilha 2 e 3
        calc.push(2);
        calc.push(3);
        
        // 2- + (empilha 5)
        calc.soma();
        
        //3- empilha 8 e 5
        calc.push(8);
        calc.push(5);
        
        // 4- - (empilha 3)
        calc.subtracao();
        
        // 5- * (empilha 15)
        calc.multiplicacao();

        //6-retorna resultado dinal
        double resultadoFinal = calc.retornarResultado();
        
        System.out.println("Resultadofinal: " + resultadoFinal);

    }
}
