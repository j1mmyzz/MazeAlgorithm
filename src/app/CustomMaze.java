package app;

import javax.swing.JPanel;
import java.awt.*;



public class CustomMaze extends JPanel{
    private int x;
    private int y;
    private JPanel[][] cells;
    public CustomMaze(int x, int y){
        this.x = x;
        this.y = y;
        setLayout(new GridLayout(x,y));
        for(int i = 0 ; i < x; i++){
            for(int j = 0; j < y; j++){
                cells[i][j] = new JPanel();
                cells[i][j].setBackground(Color.green);


            }
        }



    }

}


