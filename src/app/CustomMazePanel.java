package app;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import api.Position;

public class CustomMazePanel extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1L;

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
        setLayout(new GridLayout(cellsMaze, cellsMaze));
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
        maze = new Maze(cellsMaze - 2);
        array = maze.getArray();

        // Bingo 2
        start = current = new Position(1, 0);
        end = new Position(cellsMaze - 2, cellsMaze - 1);

        customMazeCells = new JButton[cellsMaze][cellsMaze];
        for (int i = 0; i < cellsMaze; i++) {
            for (int j = 0; j < cellsMaze; j++) {
                final int finalI = i;
                final int finalJ = j;
                customMazeCells[i][j] = new JButton();
                customMazeCells[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customMazeCells[finalI][finalJ].setBackground(Color.yellow);
                    }
                });
                add(customMazeCells[i][j]);
            }
        }
        drawMaze();
    }

    public void drawMaze() {
        for (int i = 0; i < cellsMaze; i++) {
            for (int j = 0; j < cellsMaze; j++) {
                if (array[i][j] == 0) {
                    customMazeCells[i][j].setBackground(Color.WHITE);
                } else {
                    customMazeCells[i][j].setBackground(Color.BLACK);
                }
            }
        }
        customMazeCells[start.getX()][start.getY()].setBackground(Color.GREEN);
    }

    public void autoMove() {
        Stack<Position> way = maze.getDirectWay(start, end);
        while (!way.empty()) {
            Position next = way.pop();
            int x = next.getX();
            int y = next.getY();
            customMazeCells[x][y].setBackground(Color.GREEN);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void algorithm() {
        Stack<Position> way = maze.getWay(start, end);
        while (!way.empty()) {
            Position next = way.pop();
            int x = next.getX();
            int y = next.getY();
            customMazeCells[x][y].setBackground(Color.GREEN);
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

    private void move(Position current) {
        int x = current.getX();
        int y = current.getY();

        customMazeCells[x][y].setBackground(Color.GREEN);

        // Check win
        if (passed()) {
            JOptionPane.showMessageDialog(getParent(), "You win", "Congratulation", JOptionPane.PLAIN_MESSAGE);
            refresh(this.cellsMaze);
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (maze.canMoveUp(current)) {
                current.setX(current.getX() - 1);
                move(current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (maze.canMoveRight(current)) {
                current.setY(current.getY() + 1);
                move(current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (maze.canMoveDown(current)) {
                current.setX(current.getX() + 1);
                move(current);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (maze.canMoveLeft(current)) {
                current.setY(current.getY() - 1);
                move(current);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

