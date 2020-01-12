import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View
{
    private JLabel _myLabel;
    private JButton[][] _buttonField;
    private Controller _controller;
    private int row=5, col=5;

    public View(Controller controller)
    {
        this._controller = controller;
        createButtonField(this.row, this.col);
    }

    public void createButtonField(int row, int col)
    {
        JFrame frame = new JFrame("betterTicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonField = new JPanel();
        buttonField.setLayout(new GridLayout(row,col));
        JPanel myTextPanel = new JPanel();
        myTextPanel.setLayout(new GridLayout(1,1));
        myTextPanel.setPreferredSize(new Dimension(150,50));
        _myLabel = new JLabel("player 1's turn", SwingConstants.CENTER);
        myTextPanel.add(_myLabel);

        JPanel myMainPanel = new JPanel();
        myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
        myMainPanel.add(buttonField);
        myMainPanel.add(myTextPanel);

        frame.getContentPane().add(myMainPanel);

        _buttonField = new JButton[row][col];

        for(int i = 0; i < row; i += 1)
            for(int k = 0 ; k < col; k += 1)
            {
                final int rows = i;
                final int cols = k;
                JButton button = _buttonField[rows][cols] = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                        _controller.unitClicked(rows, cols);
                    };
                });
                buttonField.add(_buttonField[i][k]);
            }

        frame.pack();
        frame.setVisible(true);
    }

    public void setButton(String marker, final int row, final int col)
    {
        _buttonField[row][col].setText(marker);
    }

    public void setPlayerTurn(final String playersTurn)
    {
        _myLabel.setText(playersTurn);
    }

    public void playerWin(final String playerWon)
    {
        _myLabel.setText(playerWon);
    }
}