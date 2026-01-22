//reaproveitando classe da questão anterior
class pares <T extends Comparable<T>, U extends Comparable <U>> implements Comparable<pares<T,U>> {
    //necessário utilziar 2 genéricos diferentes, T e U, para permitir que tenham tipos distintos
    private final T par1;
    private final U par2;
    public pares(T par1, U par2 ){
        this.par1 = par1;
        this.par2 = par2;
    } 

    public T getPar1() {
        return par1;
    }
    
    public U getPar2() {
        return par2;
    }

    @Override
    public String toString() {
        return "(" + par1 + ", " + par2 + ")" ; 
    }

    @Override
    public int compareTo (pares <T,U> outropar) {
            if (this.par1.compareTo(outropar.getPar1()) != 0 ) {

            return this.par1.compareTo(outropar.getPar1());
        } else {
            return this.par2.compareTo(outropar.getPar2());
        }

    }

}

public class A8Q5_comparadorPares {
    
    public static void main (String[] args) {
        var par1 = new pares<>(1, "Kalil");
        var par2 = new pares<>(1, "Giovanny");
        var par3 = new pares<>(3.14, 2);
        var par4 = new pares<>(0.6, 0);
        var par5 = new pares<>(0, "Giovanny");

        System.out.println("Comparacao entre pares 1 e 2");
        System.out.println(par1.compareTo(par2));
        System.out.println(" ");
        System.out.println("Comparacao entre pares 1 e 5");
        System.out.println(par1.compareTo(par5));
        System.out.println(" ");
        System.out.println("Comparacao entre pares 3 e 4");
        System.out.println(par3.compareTo(par4));
        System.out.println(" ");
        System.out.println("Comparacao entre pares 2 e 5");
        System.out.println(par2.compareTo(par5));
    }

}
