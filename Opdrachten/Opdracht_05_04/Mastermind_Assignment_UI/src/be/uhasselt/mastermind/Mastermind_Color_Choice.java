package be.uhasselt.mastermind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mastermind_Color_Choice{
    private int colorNum = 0;
    private int maxColor = 0;
    private JButton colorButton;

    public Mastermind_Color_Choice(int maxColor) {
        this.maxColor = maxColor;
        colorButton = new JButton();
        colorButton.setForeground(Color.GRAY);

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonTapped();
            }
        });
    }

    public JButton getColorButton() {
        return colorButton;
    }

    public int getColorNum() {
        return colorNum;
    }

    public void buttonTapped(){
        maxColor++;
        if(colorNum > maxColor){
            colorNum = 1;
        }

        switch (colorNum){
            case 1:
                colorButton.setForeground(Color.GREEN);
                break;
            case 2:
                colorButton.setForeground(Color.BLUE);
                break;
            case 3:
                colorButton.setForeground(Color.ORANGE);
                break;
            case 4:
                colorButton.setForeground(Color.MAGENTA);
        }

    }


}
