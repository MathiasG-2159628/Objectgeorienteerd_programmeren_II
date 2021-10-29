package mvc.app;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    //View
    private CalculatorView mCalculatorView;

    //Model
    private CalculatorModel mCalculatorModel;

    //Controller
    private CalculatorController mCalculatorController;


    public Calculator() {
        mCalculatorModel = new CalculatorModel();
        mCalculatorController = new CalculatorController(mCalculatorModel);
        mCalculatorView = new CalculatorView(mCalculatorModel, mCalculatorController);
    }

    void createGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.add(new Button("poop"));
        frame.getContentPane().add(mCalculatorView.getUI());
        frame.pack();
        frame.setVisible(true);
    }
}

class CalculatorApp{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.createGUI();

    }
}