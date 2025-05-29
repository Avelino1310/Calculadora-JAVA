import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      double nump1 = 0;
      while (true) {
         System.out.println("Digite o primeiro número:");
         if (input.hasNextDouble()) {
            nump1 = input.nextDouble();
            break;
         } else {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            input.next();
         }
      }

      String operacao = "";
      while (true) {
         System.out.println("Digite a operação desejada (+, -, *, /):");
         if (input.hasNext()) {
            operacao = input.next();
            if (operacao.equals("+") || operacao.equals("-") || operacao.equals("*") || operacao.equals("/")) {
               break;
            } else {
               System.out.println("Operação inválida. Por favor, digite uma operação válida (+, -, *, /).");
            }
         }
      }

      double nump2 = 0;
      while (true) {
         System.out.println("Digite o segundo número:");
         if (input.hasNextDouble()) {
            nump2 = input.nextDouble();
            break;
         } else {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            input.next();
         }
      }

      double resultado = 0;

      switch (operacao) {
         case "+":
            resultado = somar(nump1, nump2);
            break;
         case "-":
            resultado = subtrair(nump1, nump2);
            break;
         case "*":
            resultado = multiplicar(nump1, nump2);
            break;
         case "/":
            resultado = dividir(nump1, nump2);
            break;
         default:
            System.out.println("Operação inválida.");
            input.close();
            return;
      }

      System.out.println("Resultado: " + resultado);
      input.close();
   }

   public static double somar(double nump1, double nump2) {
      return nump1 + nump2;
   }

   public static double subtrair(double nump1, double nump2) {
      return nump1 - nump2;
   }

   public static double multiplicar(double nump1, double nump2) {
      return nump1 * nump2;
   }

   public static double dividir(double nump1, double nump2) {
      if (nump2 == 0) {
         System.out.println("Erro: divisão por zero não é permitida.");
         return 0;
      }
      return nump1 / nump2;
   }
}
