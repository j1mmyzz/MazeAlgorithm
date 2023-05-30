package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import api.Position;

public class CustomMazePanel extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1L;
    private Rectangle2D[][] cells; //remove this line later //change to JButton 2D array

    private JButton[][] customMazeCells;
    private static final int dimension = 600;
    private int[][] array;
    private int cellsMaze;
    private float cell_size;
    private Position start;
    private Position end;
    private Position current;
    private int delay = 100;
    public Maze maze;

    public CustomMazePanel(int cellsMaze) {
        addKeyListener(this);
        setLayout(new GridLayout(cellsMaze,cellsMaze));
        refresh(cellsMaze);
    }

    public int getCellsMaze() {
        return this.cellsMaze;
    }

    public void refresh(int cellsMaze) {
        this.cellsMaze = cellsMaze;
        setSize(dimension, dimension);
        cell_size = (float) (1.0 * dimension / cellsMaze);

        setFocusable(true);

        // Maze Object
        maze = new Maze(cellsMaze - 2);
        array = maze.getArray();

        // Set Position
        /*
         * Bingo Numero Dos 
         */
        start = current = new Position(1, 0);
        end = new Position(cellsMaze - 2, cellsMaze - 1);

        // Set maze on panel //remove all this later
        cells = new Rectangle2D[cellsMaze][cellsMaze];
        for (int i = 0; i < cellsMaze; i++) {
            for (int j = 0; j < cellsMaze; j++) {
                cells[i][j] = new Rectangle2D.Double(j * cell_size, i * cell_size, cell_size, cell_size);
            }
        }


        customMazeCells = new JButton[cellsMaze][cellsMaze];
        for(int i = 0; i<cellsMaze;i++){
            for(int j = 0; j < cellsMaze;j++){
                customMazeCells[i][j] = new JButton();
            }
        }

    }

   
    public void drawMaze(Graphics2D g2d) {
        for (int i = 0; i < cellsMaze; i++) {
            for (int j = 0; j < cellsMaze; j++) {
                if (array[i][j] == 0) {
                    g2d.setColor(Color.WHITE);
                } else {
                    g2d.setColor(Color.BLACK);
                }
                g2d.fill(cells[i][j]); //not sure how to fix this
            }
        }

        // Fill first cell
        int x = start.getX();
        int y = start.getY();

        g2d.setColor(Color.GREEN);
        g2d.fill(cells[x][y]);
    }

    public void autoMove(Graphics2D g2d) {
        Stack<Position> way = maze.getDirectWay(start, end);
        g2d.setColor(Color.GREEN);
        while (!way.empty()) {
            Position next = way.pop();
            int x = next.getX();
            int y = next.getY();
            g2d.fill(cells[x][y]);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void algorithm(Graphics2D g2d) {
        Stack<Position> way = maze.getWay(start, end);
        g2d.setColor(Color.GREEN);
        while (!way.empty()) {
            Position next = way.pop();
            int x = next.getX();
            int y = next.getY();
            g2d.fill(cells[x][y]);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean passed() {
        return current.equals(end);
    }

    private void move(Graphics2D g2d, Position current) {
        int x = current.getX();
        int y = current.getY();

        update((Graphics2D) this.getGraphics());

        g2d.setColor(Color.GREEN);
        g2d.fill(cells[x][y]);

        // Check win
        if(passed()) {
            JOptionPane.showMessageDialog(getParent(), "You win", "Congratulation", JOptionPane.PLAIN_MESSAGE);
            refresh(this.cellsMaze);
            repaint();
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        drawMaze((Graphics2D) g);
    }

    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (maze.canMoveUp(current)) {
                current.setX(current.getX() - 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (maze.canMoveRight(current)) {
                current.setY(current.getY() + 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (maze.canMoveDown(current)) {
                current.setX(current.getX() + 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (maze.canMoveLeft(current)) {
                current.setY(current.getY() - 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (maze.canMoveUp(current)) {
                current.setX(current.getX() - 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (maze.canMoveRight(current)) {
                current.setY(current.getY() + 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (maze.canMoveDown(current)) {
                current.setX(current.getX() + 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (maze.canMoveLeft(current)) {
                current.setY(current.getY() - 1);
                move((Graphics2D) getGraphics(), current);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}