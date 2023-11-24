import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class XOX extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JLabel l1, l2;
    JPanel p1, p3, p4;
    int player = 1;
    int matrix[][] = new int[3][3];   // Game matrix to store player moves

    public XOX() {
        p1 = new JPanel(new GridLayout(3, 3));
        p3 = new JPanel(new GridLayout(3, 1));
        p4 = new JPanel(new FlowLayout());

        l2 = new JLabel("Tic Tac Toe Game");
        l2.setFont(l2.getFont().deriveFont(24.0f));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        p3.add(l2);

        l1 = new JLabel("Player 1 Turn (X)");
        l1.setFont(l1.getFont().deriveFont(18.0f));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        p3.add(l1);

        b1 = new JButton("");
        b2 = new JButton("");
        b3 = new JButton("");
        b4 = new JButton("");`  
        b5 = new JButton("");
        b6 = new JButton("");
        b7 = new JButton("");
        b8 = new JButton("");
        b9 = new JButton("");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
       
        p4.add(resetButton);
        add(p3, BorderLayout.NORTH);    // title and player panel
        add(p1, BorderLayout.CENTER);  // box panel
        add(p4, BorderLayout.SOUTH);   // reset button panel

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // if button text is empty 
        if (clickedButton.getText().equals("")) {
            if (player == 1) {
                clickedButton.setText("X");
                matrix[getButtonRow(clickedButton)][getButtonColumn(clickedButton)] = 1;
                player = 2;
            } else {
                clickedButton.setText("O");
                matrix[getButtonRow(clickedButton)][getButtonColumn(clickedButton)] = 2;
                player = 1;
            }
            // if button text is orveride 
        } else {
            JOptionPane.showMessageDialog(this, "Cannot Mark here", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        int winner = checkWinCond();

        if (winner != 0) {
            String winnerText = (winner == 1) ? "Player 1" : "Player 2";
            JOptionPane.showMessageDialog(this, winnerText + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }

        if (checkFull() && winner == 0) {
            JOptionPane.showMessageDialog(this, "Game Draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }

        if (player == 1) {
            l1.setText("Player 1 Turn (X)");
        } else {
            l1.setText("Player 2 Turn (O)");
        }
    }

    // returning row number 
    int getButtonRow(JButton button) {
        if (button == b1 || button == b2 || button == b3) {
            return 0;
        } else if (button == b4 || button == b5 || button == b6) {
            return 1;
        } else {
            return 2;
        }
    }

    // returning col number 
    int getButtonColumn(JButton button) {
        if (button == b1 || button == b4 || button == b7) {
            return 0;
        } else if (button == b2 || button == b5 || button == b8) {
            return 1;
        } else {
            return 2;
        }
    }

    int checkWinCond() {

        // winning row line
        for (int row = 0; row < 3; row++) {
            if (matrix[row][0] == matrix[row][1] && matrix[row][1] == matrix[row][2] && matrix[row][0] != 0) {
                return matrix[row][0];
            }
        }

        // winning col line
        for (int col = 0; col < 3; col++) {
            if (matrix[0][col] == matrix[1][col] && matrix[1][col] == matrix[2][col] && matrix[0][col] != 0) {
                return matrix[0][col];
            }
        }

        // winning major diagonal wining line
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != 0) {
            return matrix[0][0];
        }

        // wining minor diagonal winning line
        if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != 0) {
            return matrix[0][2];
        }

        return 0;
    }

    boolean checkFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void resetGame() {
        player = 1;
        matrix = new int[3][3];
        l1.setText("Player 1 Turn (X)");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

    public static void main(String[] args) {
        new XOX();
    }
}
