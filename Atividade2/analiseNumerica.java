void main() {
   String numero = IO.readln("Insira um numero");

   if (Integer.parseInt(numero) < 0 ) {
   IO.println("Negativo" + " " + Math.abs(Integer.parseInt(numero))); //modulo, pois a questão pede magnitude
   } else if (Integer.parseInt(numero) == 0) {
    IO.println("Nulo");
   } else {
    IO.println("Positivo"+ " " + numero);
   }

}

