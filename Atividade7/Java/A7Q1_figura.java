/**O sistema de classes se baseia no seguinte:
 *  uma superclasse raiz (a publica principal do arquivo) figura
 * a partir da figura surgem 2 subclasses, bidimensionais e tridimensionais
 * as bidimensionais geram subclasses círculos, retângulos e triângulos
 * as tridimensionais geram subclasses esferas tetraedros e prismas
 */ 

//classe abstrata figura, a raiz
public abstract class A7Q1_figura {
    //como cor é um atributo intríseco a toda e qualquer figura é conveniente colocar ele aqui
    //defini como protected, para que seja visível para as classes derivadas 
    //isso facilita a definição da cor direto na instanciação da subclasse, sem métodos auxiliares
    protected String cor;

}


//classe abstrata bidimensional, superclasse para as figuras bidimensionais
abstract class bidimensional extends A7Q1_figura {
    //usando protected para não precisar definir por método auxiliar, mas mantendo encapsulamento
    protected double Area;

    protected abstract void CalculaArea(); 
}


//classe responsável por círculos
class Circulo extends bidimensional {
    private double raio; 
    private double pi = 3.14159;
    
    public Circulo (String Cor, double Raio) {
        this.cor = Cor;
        this.raio = Raio;
        CalculaArea(); //define o valor do atributo área automaticamente
    }

    @Override
    protected void CalculaArea() {
        Area = pi*raio*raio;
    }
    public String toString() {
        return "Circulo, Cor: " + cor + ", Area: " + Area ;
    }
}

//classe responsável por retângulos
class Retangulo extends bidimensional {
    private double base;
    private double altura;

    public Retangulo (String Cor, double Base, double Altura) {
        this.cor = Cor;
        this.base = Base;
        this.altura = Altura;
        CalculaArea(); //define o valor do atributo área automaticamente
    }

    @Override
    protected void CalculaArea() {
        Area = base * altura;
    }
    public String toString() {
        return "Retangulo, Cor: " + cor + ", Area: " + Area ;
    }
}

//classe responsável por triângulos
class Triangulo extends bidimensional{
    private double base;
    private double altura;

    public Triangulo (String Cor, double Base, double Altura) {
        this.cor = Cor;
        this.base = Base;
        this.altura = Altura;
        CalculaArea(); //define o valor do atributo área automaticamente
    }

    @Override
    protected void CalculaArea() {
        Area = (base*altura)/2;
    }
    public String toString() {
        return "Triangulo, Cor: " + cor + ", Area: " + Area ;
    }
}


//AGORA AS CLASSES REFERENTES A OBJETOS TRIDIMENSIONAIS
abstract class tridimensional extends A7Q1_figura {
    //volume protected, para facilitar a definição no construtor das subclasses, mantendo encapsulamento
    protected double Volume;

    protected abstract void CalcularVolume();

}

class Esfera extends tridimensional {
    private double raio;
    private double pi = 3.14159;

    public Esfera(String Cor, double Raio) {
        this.cor = Cor;
        this.raio = Raio;
        CalcularVolume(); //define o valor do atributo volume automaticamente
    }

    @Override
    protected void CalcularVolume() {
        Volume = (4.0/3.0 ) * pi * raio*raio*raio;
    }
    public String toString() {
        return "Esfera, Cor: " + cor + ", Volume: " + Volume ;
    }
}

class Tetraedro extends tridimensional {
    private double base;
    private double altura;

    public Tetraedro(String Cor, double Base, double Altura) {
        this.cor = Cor;
        this.base = Base;
        this.altura = Altura;
        CalcularVolume(); //define o valor do atributo volume automaticamente
    }

    @Override
    protected void CalcularVolume() {
        Volume = base * altura/3;
    }
    public String toString() {
        return "Tetraedro, Cor: " + cor + ", Volume: " + Volume ;
    }
}

class Prisma extends tridimensional {
    private double base;
    private double altura;

    public Prisma(String Cor, double Base, double Altura) {
        this.cor = Cor;
        this.base = Base;
        this.altura = Altura;
        CalcularVolume(); //define o valor do atributo volume automaticamente
    }
    @Override
    protected void CalcularVolume() {
        Volume = base*altura;
    }

    public String toString() {
        return "Prisma, Cor: " + cor + ", Volume: " + Volume ;
    }

}