import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField textField;
    JButton[] buttons;
    String[] buttonValues = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};

    public Calculator() {
        super("Calculator");

        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        buttons = new JButton[buttonValues.length];

        for (int i = 0; i < buttonValues.length; i++) {
            buttons[i] = new JButton(buttonValues[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        String text = textField.getText();

        if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            textField.setText(text + " " + buttonText + " ");
        } else if (buttonText.equals("=")) {
            try {
                double result = Double.parseDouble(text.substring(0, text.indexOf(" ")))
                                 + Double.parseDouble(text.substring(text.lastIndexOf(" ") + 1));
                textField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                textField.setText("Invalid input");
            }
        } else {
            textField.setText(text + buttonText);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
