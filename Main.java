import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private JFrame frame;
    private JTextField campo;
    private double num1, num2, resultado;
    private String operador;

    public Main() {
        frame = new JFrame("Calculadora");
        campo = new JTextField();
        campo.setEditable(false);
        campo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            painel.add(botao);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String t = ((JButton) e.getSource()).getText();
                    if ("0123456789.".contains(t)) {
                        campo.setText(campo.getText() + t);
                    } else if ("+-*/".contains(t)) {
                        num1 = Double.parseDouble(campo.getText());
                        operador = t;
                        campo.setText("");
                    } else if ("=".equals(t)) {
                        num2 = Double.parseDouble(campo.getText());
                        switch (operador) {
                            case "+": resultado = num1 + num2; break;
                            case "-": resultado = num1 - num2; break;
                            case "*": resultado = num1 * num2; break;
                            case "/":
                                if (num2 == 0) {
                                    campo.setText("Erro");
                                    return;
                                }
                                resultado = num1 / num2; break;
                        }
                        campo.setText(String.valueOf(resultado));
                    } else if ("C".equals(t)) {
                        campo.setText("");
                    }
                }
            });
        }

        frame.setLayout(new BorderLayout());
        frame.add(campo, BorderLayout.NORTH);
        frame.add(painel, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}