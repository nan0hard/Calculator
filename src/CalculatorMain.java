import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorMain implements ActionListener {
    JFrame jFrame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clearButton, negButton;

    JPanel jPanel;

    Font myFont = new Font("serif", Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator ;

    CalculatorMain() {
        jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420,530);
        jFrame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("DEL");
        clearButton = new JButton("CLS");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equalButton;
        functionButton[6] = delButton;
        functionButton[7] = clearButton;
        functionButton[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clearButton.setBounds(250,430,100,50);

        jPanel = new JPanel();

        jPanel.setBounds(50,100,300,300);
        jPanel.setLayout(new GridLayout(4,4,10,10));

        jPanel.add(numberButton[1]);
        jPanel.add(numberButton[2]);
        jPanel.add(numberButton[3]);
        jPanel.add(addButton);
        jPanel.add(numberButton[4]);
        jPanel.add(numberButton[5]);
        jPanel.add(numberButton[6]);
        jPanel.add(subButton);
        jPanel.add(numberButton[7]);
        jPanel.add(numberButton[8]);
        jPanel.add(numberButton[9]);
        jPanel.add(mulButton);
        jPanel.add(decButton);
        jPanel.add(numberButton[0]);
        jPanel.add(equalButton);
        jPanel.add(divButton);

        jFrame.add(jPanel);
        jFrame.add(negButton);
        jFrame.add(delButton);
        jFrame.add(clearButton);
        jFrame.add(textField);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CalculatorMain calculatorMain = new CalculatorMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numberButton[i])
                textField.setText(textField.getText().concat(String.valueOf(i)));
        }

        if(e.getSource() == decButton)
            textField.setText(textField.getText().concat("."));

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) textField.setText("");

        if (e.getSource() == delButton) {
            String temp = textField.getText();
            textField.setText("");
            for(int i = 0; i < temp.length() - 1; i++)
                textField.setText(textField.getText() + temp.charAt(i));
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

}
