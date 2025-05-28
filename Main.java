import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o primeiro número:");
        double a = input.nextDouble();

        System.out.println("Digite o segundo número ");
        double b = input.nextDouble();

        System.out.println("Digite o operador (+, -, *, /):");
        String operacao = input.next();


        switch (operacao) {
            case "+" -> System.out.println(a + b);
            case "-" -> System.out.println(a - b);
            case "*" -> System.out.println(a * b);
            case "/" -> {
                if (b != 0) {
                    System.out.println(a / b);
                } else
                    System.out.println("Erro : divisão por zero");
            }
            default -> System.out.println("operação: invalida");
        }

        }

    }
}
