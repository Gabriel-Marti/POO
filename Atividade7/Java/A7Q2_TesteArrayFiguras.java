import java.util.Scanner;

public class A7Q2_TesteArrayFiguras {
    //array com objetos das subclasses com mesma classe comum da questão anterior
    //para não precisar reescrever o código inteiro nesse arquivo, vou apenas escrever o programa
    //considerando a classe definida na questão anterior

    int TAMANHO_MAXIMO = 6; //tamanho definido pois são 6 figuras distintas, alteravel
    A7Q1_figura[] listaFiguras = new A7Q1_figura[TAMANHO_MAXIMO];
    

    public static void main(String[] args) {
        String cor;
        double raio;
        double base;
        double altura;

        Scanner Scanner = new Scanner(System.in);
        A7Q2_TesteArrayFiguras TestadorArray = new A7Q2_TesteArrayFiguras();

        //O ARRAY TEM 6 ELEMENTOS, PARA 6 FIGURAS DISTINTAS:

        // 1- criando um objeto circulo no array
        System.out.println("Insira a cor do círculo");
        cor = Scanner.nextLine();
        System.out.println("Insira o raio do círculo");
        raio = Scanner.nextDouble();
        
        TestadorArray.listaFiguras[0] = new Circulo(cor, raio);

        //2- criando um objeto retangulo no array
        System.out.println("Insira a cor do retangulo");
        Scanner.nextLine(); //limpeza de buffer
        cor = Scanner.nextLine();
        System.out.println("Insira a base do retangulo");
        base = Scanner.nextDouble();
        System.out.println("Insira a altura do retangulo");
        altura = Scanner.nextDouble();
        TestadorArray.listaFiguras[1] = new Retangulo(cor, base, altura);

        //3- criando um objeto triangulo no array
        System.out.println("Insira a cor do triangulo");
        Scanner.nextLine(); //limpeza de buffer
        cor = Scanner.nextLine();
        System.out.println("Insira a base do triangulo");
        base = Scanner.nextDouble();
        System.out.println("Insira a altura do triangulo");
        altura = Scanner.nextDouble();
        TestadorArray.listaFiguras[2] = new Triangulo(cor, base, altura);

        //4- criando um objeto esfera no array
        System.out.println("Insira a cor da esfera");
        Scanner.nextLine(); //limpeza de buffer
        cor = Scanner.nextLine();
        System.out.println("Insira o raio da esfera");
        raio = Scanner.nextDouble();
        TestadorArray.listaFiguras[3] = new Esfera(cor, raio);

        //5- criando um objeto tetraedro no array
        System.out.println("Insira a cor do tetraedro");
        Scanner.nextLine(); //limpeza de buffer
        cor = Scanner.nextLine();
        System.out.println("Insira a área da base do tetraedro");
        base = Scanner.nextDouble();
        System.out.println("Insira a altura do tetraedro");
        altura = Scanner.nextDouble();
        TestadorArray.listaFiguras[4] = new Tetraedro(cor, base, altura);

        //6- criando um objeto prisma no array
        System.out.println("Insira a cor do prisma");
        Scanner.nextLine(); //limpeza de buffer
        cor = Scanner.nextLine();
        System.out.println("Insira a área da base do prisma");
        base = Scanner.nextDouble();
        System.out.println("Insira a altura do prisma");
        altura = Scanner.nextDouble();
        TestadorArray.listaFiguras[5] = new Prisma(cor, base, altura);


        //VERIFICANDO SE HÁ COR REPETIDA
        if (TestadorArray.verificarCorRepetida(TestadorArray.listaFiguras)) {
            System.out.println("Existem figuras com cores repetidas na lista");
        } else {
            System.out.println("Nenhuma figura tem a mesma cor na lista");
        }

        //calcula a area de todas as figuras 2D
        TestadorArray.CalcularAreaGeral(TestadorArray.listaFiguras);
        //calcula o volume de todas as figuras 3D
        TestadorArray.CalcularVolumeGeral(TestadorArray.listaFiguras);

    }

    //método para veficiar se existe cor repetida
    public boolean verificarCorRepetida(A7Q1_figura[] lista) {
        int i;
        //primeiro loop faz a verificação em todos os elementos da lista
        //caso o indice i chegue no ultimo elemento, não faz sentido verificar, então para em tamanho-1
        for(i=0 ; i<TAMANHO_MAXIMO-1; i++) {
            int j;
            //segundo loop garante que cada elemento seja comparado com todos os outros
            for (j=0; j< TAMANHO_MAXIMO - i -1 ; j++) {
                if (lista[i].cor.equals(lista[i+1+j].cor) ) {
                //se durante a iteração, algum elemento no array de figuras tiver mesmacor, é true
                return true; //return true mata afunção já na primeira verificação
            }
            }
            
        }
        //se não for encontrado objeto com a mesma cor, retorna false
        return false;
    }


    //metodo para calcular a area de cada uma das figuras 2D no array de figuras
    public void CalcularAreaGeral(A7Q1_figura[] lista) {
        int i;
        for (i=0 ; i<TAMANHO_MAXIMO ; i++) {
            if (lista[i] instanceof bidimensional) {
                bidimensional Figura2D = (bidimensional) lista[i];
                System.out.println("Area" + (i+1) + ": " + Figura2D.Area);

            }
        }
    }


    //método para calcular o volume de cada uma das figuras 3D no array de figuras
    public void CalcularVolumeGeral(A7Q1_figura[] lista) {
        int i;
        for (i=0 ; i<TAMANHO_MAXIMO; i++) {
            if (lista[i] instanceof tridimensional) {
                tridimensional Figura3D = (tridimensional) lista[i];
                System.out.println("Volume" + (i+1) + ": " + Figura3D.Volume);
            }
        }
    }

}
