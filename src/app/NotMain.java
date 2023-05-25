package app;//package app;


import java.io.IOException;
import javax.swing.*;
import java.awt.*;




public class Main{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame maze = new JFrame("Jimmy's Maze Solving Algorithm");
                    maze.setSize(625, 675);
                    maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    maze.setLayout(null);


                    JLabel welcome1 = new JLabel("Maze Solver");
                    welcome1.setFont(new Font("Arial", Font.PLAIN, 60));
                    welcome1.setBounds(130, 20, 800, 90);
                    maze.add(welcome1);


                    JLabel welcome2 = new JLabel("By: Jimmy Zheng");
                    welcome2.setFont(new Font("Arial", Font.PLAIN, 60));
                    welcome2.setBounds(60, 100, 800, 90);
                    maze.add(welcome2);


                    JLabel imgLabel = new JLabel(new ImageIcon("src/app/image/mazeart.jpg"));
                    imgLabel.setPreferredSize(new Dimension(300,275));
                    imgLabel.setBounds(20, 100, 550, 550);
                    maze.add(imgLabel);


                    JButton generateRandomMaze = new JButton("Generate Random Maze");
                    JButton createCustomMaze = new JButton("Create Custom Maze");
                    generateRandomMaze.setBounds(40,560, 200,50);
                    createCustomMaze.setBounds(380,560, 200,50);
                    maze.add(generateRandomMaze);
                    maze.add(createCustomMaze);


                    maze.setVisible(true);
                    maze.repaint();
                    MazeGUI frame = new MazeGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


