//como não foi especificado considerei que a loja vende garrafas iguais com preços iguais por simplicidade

void main() {
   int quantidade_garrafas = Integer.parseInt(IO.readln("Insira quantas garrafas comprará:"));
   double precoGarrafas = Double.parseDouble(IO.readln("Insira o preco individual da garrafa"));
   int novaquantidade = 2*(quantidade_garrafas/3) + quantidade_garrafas%3;

   double precoTotal = novaquantidade * precoGarrafas;

   IO.println("O preco total é: " + precoTotal);
}