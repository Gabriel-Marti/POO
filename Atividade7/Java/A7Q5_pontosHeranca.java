

//NOTA: no java, uma herança indica que a sublasse é parte da superclasse ou se comporta como ela
//assim: ClasseA extends ClasseB indca que classe A se comporta como a classe B
//desse modo fazer um sistema de herança Ponto3D extends Ponto2D significaria dizer que
//por pontos 3D herdarem de 2D, então pontos 3D fariam parte de pontos 2D (na verdade é o contrário)
//existe também o problema para o equals, se p2 =(1,1) e p3=(1,1,2):
//p2.equals(p3) daria true, pois x e y são iguais e p3.equals(p2) também. por usar a logica do pai
//assim em comparações a tereceira coordenada seria anulada, chegando a uma mentira matemática
//é possível também sobrescrever o equals para chegar no z, mas isso quebraria a simetrai do equals
//ASSIM O PROBLEMA É CONCEITUAL uma vez que a comparação e interação entre esses 2 
//em uma relação de herança gera comportamentos matematicamente incorretos, são tipos imcompativeis

//eu poderia na hernaça adicionar a nova coordenada z e um novo método para calcular distancia 3D
//mantendo o antigo metodo de calcular distancia 2D para calcular projeções e o novo para distancias
//entretanto isso seria ineficiente devido aos motivos citados anteriormente

//Nota: sem adicionar novo método, apenas fazendo substiutição de método para calcular distancia
//o polimorfismo por substiuição se perderia, uma vez que na distância da nova classe 3D
//seria necessário usar um método com assinatura diferente, recebendo 3 coordenadas

//para que as classes tenham algum sentido como herança é preciso usar métodos diferentes 

//AINDA ASSIm, fazer o que a questão pediu a princípio

//essa classe vai dizer respeito ao ponto 2D
public class A7Q5_pontosHeranca {
    private double X;
    private double Y;

    public A7Q5_pontosHeranca(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    //como a origem é o ponto O=(0,0) então basta somar os quadrados e ignorar a subtração
    public double distanciaAOrigem() {
        return Math.sqrt(X * X + Y * Y);
    }

    public double distancia(A7Q5_pontosHeranca Ponto2D) {
        return Math.sqrt((X-Ponto2D.getX())*(X-Ponto2D.getX()) + (Y-Ponto2D.getY())*(Y-Ponto2D.getY()));
    }

    public double getX() {
        return X;
    }
    public double getY() {
        return Y;
    }
    public void setX(double x) {
        X = x;
    }
    public void setY(double y) {
        Y = y;
    }

}

class Ponto3D extends A7Q5_pontosHeranca {
    private double Z;

    public Ponto3D(double x, double y, double z ) {
        super(x,y);
        this.Z = z;
    }

    //Reescrever a função de distancia à origem para calcular em 3 dimensões
    @Override
    public double distanciaAOrigem() {
        return Math.sqrt(getX()*getX() + getY()*getY() + Z*Z);
    }

    public double distancia(Ponto3D ponto3D) {
        return Math.sqrt((getX()-ponto3D.getX())*(getX()-ponto3D.getX()) + (getY()-ponto3D.getY())*(getY()-ponto3D.getY()) + (Z-ponto3D.getZ())*(Z-ponto3D.getZ()) );
    }
    //chamar p2d.distancia(p3d) faz cair no método do pai e ignorar Z


    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

}

