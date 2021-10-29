package be.uhasselt.mastermind;

import be.uhasselt.AbstractView;

import java.awt.*;
import java.util.Observable;

public class Mastermind_UI extends javax.swing.JFrame implements java.util.Observer{
    Mastermind_Color_Choice[][] color_rows  = new Mastermind_Color_Choice[12][4];

    public Mastermind_UI(){

    }

    private void initRows(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 4; j++){
                color_rows[i][j] = new Mastermind_Color_Choice(4);
                this.getContentPane().add((color_rows[i][j]).getColorButton());
            }
        }
    }

    public void initComponents(){

        getContentPane().setLayout(new GridLayout(12, 4));

        initRows();
        pack();
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
