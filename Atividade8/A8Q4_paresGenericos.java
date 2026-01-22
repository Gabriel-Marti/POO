
class par <T,U> {
    //necessário utilziar 2 genéricos diferentes, T e U, para permitir que tenham tipos distintos
    private final T par1;
    private final U par2;
    public par(T par1, U par2 ){
        this.par1 = par1;
        this.par2 = par2;
    } 

    public T getPar1() {
        return par1;
    }
    
    public U getPar2() {
        return par2;
    }

}

public class A8Q4_paresGenericos {
    public static void main (String[] args) {
        par<?, ?> par1 = new par<>(1, 0);
        par<?, ?> par2 = new par<>("Giovanny", 1);
        par<?, ?> par3 = new par<>(3.14,"Kalil");
        par<?, ?> par4 = new par<>(0.6, 0);

        System.out.println(par1.getPar1());
        System.out.println(par1.getPar2());
        System.out.println(par2.getPar1());
        System.out.println(par3.getPar1());
        System.out.println(par3.getPar2());
        System.out.println(par4.getPar1());
    }

}
