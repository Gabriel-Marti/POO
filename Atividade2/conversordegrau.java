//Assumindo centigrados=graus celsius

double celsiusParaFahrenheit(double celsius) {
    //9.0 e 5.0 usados para garantir a divisão com casas decimais
    return (celsius * 9.0 / 5.0) + 32;
}

double fahrenheitParaCelsius(double fahrenheit) {
    //5.0 e 9.0 usados para garantir a divisão com casas decimais
    return (fahrenheit - 32) * 5.0 / 9.0;
}


void main() {
    double grau = Double.parseDouble(IO.readln("Insira os graus"));
    IO.println("Conversor de graus, Fahrenheit e Celsius");
    IO.println("Digite 'Fahrenheit' para converter de Celsius para Fahrenheit ");
    IO.println("Digite 'Celsius' para converter de Fahrenheit para Celsius");
    String opcao = IO.readln("Escolha o conversor: ");

    if (opcao.equalsIgnoreCase("Fahrenheit")) {
        IO.println("o valor em Fahrenheit é:" + " " + celsiusParaFahrenheit(grau));
    } else if (opcao.equalsIgnoreCase("Celsius")) {
        IO.print("O valor em Celsius é:" + " " + fahrenheitParaCelsius(grau));
    } else {
        IO.print("Opção inválida");
    }
}
