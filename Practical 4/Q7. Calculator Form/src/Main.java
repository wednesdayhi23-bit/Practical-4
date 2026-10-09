//Aim: To develop a GUI calculator that performs addition, subtraction, multiplication, and division on two numbers.


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {
    JTextField num1, num2, result;
    JButton add, subtract, multiply, divide;

    Calculator() {
        setTitle("Simple Calculator");
        setLayout(new FlowLayout());

        add(new JLabel("First Number:"));
        num1 = new JTextField(10);
        add(num1);

        add(new JLabel("Second Number:"));
        num2 = new JTextField(10);
        add(num2);

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");

        add(add);
        add(subtract);
        add(multiply);
        add(divide);

        add(new JLabel("Result:"));
        result = new JTextField(15);
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double ans;

            if (e.getSource() == add) {
                ans = a + b;
            } else if (e.getSource() == subtract) {
                ans = a - b;
            } else if (e.getSource() == multiply) {
                ans = a * b;
            } else {
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                ans = a / b;
            }

            result.setText(String.valueOf(ans));

        } catch (NumberFormatException ex) {
            result.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
