package app;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class MazeGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private MazePanel mazePane;
    private JPanel menuBar;
    private JPanel computer;


    public MazeGUI() {
        setSize(625, 675);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Maze Solver");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Menu Bar
        menuBar = new JPanel();
        contentPane.add(menuBar, BorderLayout.NORTH);
        // Menu
        computer = new JPanel();

        //Add
        menuBar.add(computer);

        JButton restart = new JButton(new AbstractAction("Restart") {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        
        JButton autoMove = new JButton(new AbstractAction("Solve") {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
                mazePane.autoMove((Graphics2D) mazePane.getGraphics());
            }
        });
    
        computer.add(autoMove);
        computer.add(restart);
       
        mazePane = new MazePanel(Main.getMazeSize()); //This is where you control the size
        contentPane.add(mazePane, BorderLayout.CENTER);
    }
    
}


