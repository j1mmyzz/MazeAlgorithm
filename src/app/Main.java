package app;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Main{
    private static int mazeSize = 0;
    public static int getMazeSize(){
        return mazeSize;
    }
    public static void setMazeSize(int x){
        mazeSize = x;
    }
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
                    generateRandomMaze.setBounds(40, 560, 200, 50);
                    createCustomMaze.setBounds(380, 560, 200, 50);
                    generateRandomMaze.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            // Create and configure the maze level selection frame
                            JFrame levels = new JFrame("Maze Size");
                            levels.setSize(300, 200);
                            levels.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            levels.setLayout(null);

                            JLabel levelLabel = new JLabel("Enter an odd Integer: ");
                            levelLabel.setBounds(10, 10, 150, 25);

                            JTextField levelTextField = new JTextField();
                            levelTextField.setBounds(140, 10, 120, 25);

                            JButton backButton = new JButton("Back");
                            backButton.setBounds(10, 50, 80, 25);
                            backButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    levels.dispose(); // Close the maze level selection frame
                                }
                            });

                            JButton generateButton = new JButton("Generate");
                            generateButton.setBounds(140, 50, 100, 25);
                            generateButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String mazeLevel = levelTextField.getText();
                                    int parsed = Integer.parseInt(mazeLevel);
                                    mazeSize = parsed;
                                    MazeGUI frame = new MazeGUI();
                                    frame.setVisible(true);
                                    levels.dispose();
                                }
                            });

                            levels.add(levelLabel);
                            levels.add(levelTextField);
                            levels.add(backButton);
                            levels.add(generateButton);

                            levels.setVisible(true); 
                        }
                    });
                    createCustomMaze.addActionListener(new ActionListener() {
                        @Override
                            public void actionPerformed(ActionEvent e) {
                                CustomMazeGUI custom = new CustomMazeGUI();
                                custom.setVisible(true);
                            }
                    });
                    maze.add(generateRandomMaze);
                    maze.add(createCustomMaze);

                    maze.add(generateRandomMaze);
                    maze.add(createCustomMaze);


                    maze.setVisible(true); //change this to true later
                    maze.repaint();

                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


