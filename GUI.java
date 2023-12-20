package CodePTIT_Java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private String currentInput = "";
    private double result = 0;
    private String operator = "";

    public GUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        display = new JTextField(10);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));

        panel = new JPanel(new GridLayout(5, 4));

        String[] buttonLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", ".", "=", "/",
                "C", "CE"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                currentInput = "";
                result = 0;
                operator = "";
            } else if (command.equals("CE")) {
                currentInput = "";
            } else if (command.equals("=")) {
                calculateResult();
            } else if (command.matches("[0-9]")) {
                currentInput += command;
            } else if (command.matches("[+\\-*/]")) {
                if (!currentInput.isEmpty()) {
                    calculateResult();
                }
                operator = command;
            } else if (command.equals(".")) {
                if (!currentInput.contains(".")) {
                    currentInput += ".";
                }
            }

            display.setText(currentInput);
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double input = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    result += input;
                    break;
                case "-":
                    result -= input;
                    break;
                case "*":
                    result *= input;
                    break;
                case "/":
                    if (input != 0) {
                        result /= input;
                    } else {
                        currentInput = "Error";
                        operator = "";
                        return;
                    }
                    break;
            }
            currentInput = "";
            operator = "";
            currentInput = Double.toString(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
