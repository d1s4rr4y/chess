package board;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Chessboard {
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessboardSquares = new JButton[8][8];
    private JPanel chessboard;
    private final JLabel message = new JLabel("Test Label");
    private static final String COLS = "ABCDEFGH";

    public Chessboard() {
        initialiseGui();
    }

    public final void initialiseGui() {
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New"));
        // tools.add(new JButton("Save"));
        // tools.add(new JButton("Restore"));
        tools.addSeparator();
        tools.add(new JButton("Resign"));
        tools.addSeparator();
        tools.add(message);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessboard = new JPanel(new GridLayout(0, 9));
        chessboard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessboard);

        Insets buttonMargin = new Insets(0,0,0,0);

        for(int i = 0; i < chessboardSquares.length; i++) {
            for(int j = 0; j < chessboardSquares[i].length; j++){
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);

                Color background = (j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0) ? Color.WHITE : Color.BLACK;
                b.setBackground(background);

                b.getModel().addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        ButtonModel model = (ButtonModel) e.getSource();
                        if(model.isRollover()) {
                            b.setBackground(Color.RED);
                        } else {
                            b.setBackground(background);
                        }
                    }
                });
                chessboardSquares[j][i] = b;
            }
        }

        chessboardSquares[0][0].setIcon(new ImageIcon(ChessSprites.GOLD_ROOK));
        chessboardSquares[1][0].setIcon(new ImageIcon(ChessSprites.GOLD_KNIGHT));
        chessboardSquares[2][0].setIcon(new ImageIcon(ChessSprites.GOLD_BISHOP));
        chessboardSquares[3][0].setIcon(new ImageIcon(ChessSprites.GOLD_KING));
        chessboardSquares[4][0].setIcon(new ImageIcon(ChessSprites.GOLD_QUEEN));
        chessboardSquares[5][0].setIcon(new ImageIcon(ChessSprites.GOLD_BISHOP));
        chessboardSquares[6][0].setIcon(new ImageIcon(ChessSprites.GOLD_KNIGHT));
        chessboardSquares[7][0].setIcon(new ImageIcon(ChessSprites.GOLD_ROOK));
        

        for(int i = 0; i < chessboardSquares[1].length; i++) {
            ImageIcon icon = new ImageIcon(ChessSprites.GOLD_PAWN);
            chessboardSquares[i][1].setIcon(icon);
        }

        chessboardSquares[0][7].setIcon(new ImageIcon(ChessSprites.SILVER_ROOK));
        chessboardSquares[1][7].setIcon(new ImageIcon(ChessSprites.SILVER_KNIGHT));
        chessboardSquares[2][7].setIcon(new ImageIcon(ChessSprites.SILVER_BISHOP));
        chessboardSquares[3][7].setIcon(new ImageIcon(ChessSprites.SILVER_KING));
        chessboardSquares[4][7].setIcon(new ImageIcon(ChessSprites.SILVER_QUEEN));
        chessboardSquares[5][7].setIcon(new ImageIcon(ChessSprites.SILVER_BISHOP));
        chessboardSquares[6][7].setIcon(new ImageIcon(ChessSprites.SILVER_KNIGHT));
        chessboardSquares[7][7].setIcon(new ImageIcon(ChessSprites.SILVER_ROOK));

        for(int i = 0; i < chessboardSquares[6].length; i++) {
            ImageIcon icon = new ImageIcon(ChessSprites.SILVER_PAWN);
            chessboardSquares[i][6].setIcon(icon);
        }

        chessboard.add(new JLabel(""));
        for(int i = 0; i < 8; i++) {
            chessboard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                switch(j) {
                    case 0:
                        chessboard.add(new JLabel("" + (8 - i),
                                SwingConstants.CENTER));
                    default:
                        chessboard.add(chessboardSquares[j][i]);
                }
            }
        }
    }

    // public final JButton getSpace(int i, int j) {
    //     return chessboardSquares[i][j];
    // }

    public final JComponent getChessboard() {
        return chessboard;
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Chessboard cb = new Chessboard();

                JFrame f = new JFrame("Chess");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

