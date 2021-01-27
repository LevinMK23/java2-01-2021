package lesson4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CalculatorController implements Initializable {

    public TextField output;
    private String operation;
    private long leftOperand;

    public void inputDigit(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        output.appendText(btn.getText());
    }

    public void calculate(ActionEvent actionEvent) {
        calculate();
    }

    private void calculate() {
        long rightOperand = Long.parseLong(output.getText());
        switch (operation) {
            case "+":
                output.setText(String.valueOf(leftOperand + rightOperand));
                break;
            case "-":
                output.setText(String.valueOf(leftOperand - rightOperand));
                break;
            case "*":
                output.setText(String.valueOf(leftOperand * rightOperand));
                break;
            case "/":
                output.setText(String.valueOf(leftOperand / rightOperand));
                break;
        }
    }

    public void operate(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        operate(btn.getText());
    }

    private void operate(String operation) {
        this.operation = operation;
        leftOperand = Long.parseLong(output.getText());
        clear();
    }

    public void clear(ActionEvent actionEvent) {
        clear();
    }

    private void clear() {
        output.clear();
    }

    public void keyListen(KeyEvent keyEvent) {
        String str = keyEvent.getText();
        if (str.matches("[0-9]")) {
            output.appendText(keyEvent.getText());
        }else if (str.equals("+") ||str.equals("-") || str.equals("*") || str.equals("/")) {
            operate(keyEvent.getText());
            clear();
        } else if (str.equals("=")) {
            calculate();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
