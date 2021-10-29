package mvc.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class CalculatorView extends AbstractView{

    private JPanel mPanel;
    private JTextField mCalculatorField;


    //Number buttons

    private ArrayList<JButton> numberButtons = new ArrayList<>();

    private JButton mButtonSubtract;
    private JButton mButtonAdd;
    private JButton mButtonDivide;
    private JButton mButtonMultiply;
    private JButton mButtonEquals;

    private GridLayout gridLayout;

    public CalculatorView(Observable model, Controller controller){
        super(model, controller);
        init();
    }

    private void init(){
        mPanel = new JPanel();
        mPanel.setLayout(new GridLayout(4, 1));

        mCalculatorField = new JTextField("0", 3);
        mPanel.add(mCalculatorField);

        for(int i = 1; i <= 9; i++){
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    CalculatorController controller = (CalculatorController) getController();
                    controller.AddNumber(button.getText());
                }
            });

            mPanel.add(button);
        }

        mButtonSubtract = new JButton("-");
        mButtonAdd = new JButton("+");
        mButtonDivide = new JButton("/");
        mButtonMultiply = new JButton("x");
        mButtonEquals = new JButton("=");

        mPanel.add(mButtonSubtract);
    }

    public JComponent getUI(){
        return mPanel;
    }

    public void AddNumberToText(String number){
        this.mCalculatorField.setText(this.mCalculatorField.getText() + number);
    }
}
