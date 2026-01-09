
//essa vai ser a classe referente a pontos 2D
public class A7Q5_pontosSemHeranca {
    private double X;
    private double Y;

    public A7Q5_pontosSemHeranca(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    public double distanciaAOrigem() {
        return Math.sqrt(X*X + Y*Y);
    }

    public double distancia(A7Q5_pontosSemHeranca Ponto2D) {
        return Math.sqrt((X-Ponto2D.getX())*(X-Ponto2D.getX()) + (Y-Ponto2D.getY())*(Y-Ponto2D.getY()) );
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

//a classe referente a pontos 3D que vai aproveitar a composição dos pontos 2D
class Ponto3D {
    private A7Q5_pontosSemHeranca Ponto2D;
    private double Z;

    public Ponto3D(double x, double y, double z) {
        Ponto2D = new A7Q5_pontosSemHeranca(x, y);
        this.Z = z;
    } 

    public double distanciaAOrigem() {
        return Math.sqrt(Ponto2D.getX()*Ponto2D.getX() + Ponto2D.getY()*Ponto2D.getY() + Z*Z );
    }

    //para não ter que reescrever a fórmula para cada coordenada é possível reaproveitar a composição
    //um objeto da classe Ponto3D está sendo passado como parâmetro, que também tem parte 2D
    //asim é possível comparar a distância entre as partes 2D de ambos objetos, reduzindo a escrita
    //para isso basta usar o próprio método do objeto dentro deste objeto de modo que o método desse 
    //objeto 2D receba o o atributo2D do parâmetro 3D recebido por esse método
    //assim a distância 2D é calculada e pode ser composta à Z para calcular a distancia total
    //como a distancia 2D é uma raiz quadrada, é preciso multiplicar ela por ela mesma
    public double distancia(Ponto3D outroPonto) {
        return Math.sqrt(this.Ponto2D.distancia(outroPonto.Ponto2D)*this.Ponto2D.distancia(outroPonto.Ponto2D) + (this.Z-outroPonto.getZ())*(this.Z-outroPonto.getZ()));
    }

    public double getX() {
        return Ponto2D.getX();
    }
    public double getY() {
        return Ponto2D.getY();
    }
    public double getZ() {
        return Z;
    }
    public void setX(double x) {
        Ponto2D.setX(x);
    }
    public void setY(double y) {
        Ponto2D.setY(y);
    }
    public void setZ(double z) {
        Z = z;
    }
}