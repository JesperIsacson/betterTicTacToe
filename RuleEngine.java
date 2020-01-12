public class RuleEngine {
    private Controller _controller;
    private int _winCondition = 3;
    private boolean _boardForEachPlayer = false;

    public RuleEngine(Controller controller) {
        this._controller = controller;
    }

    public String stringMarker(final int playersTurn) {
        char marker = charMarker(playersTurn);
        String value = String.valueOf(marker);
        return value;
    }

    public char charMarker(final int playersTurn) {
        int character = 65 + playersTurn;
        char marker = (char) character;
        return marker;
    }

    public boolean validMove(char[][] board, final int row, final int col) {
        if (board[row][col] == ' ')
            return true;
        return false;
    }

    public String playersTurn(final int playersTurnNr)
    {
        String turn = String.format("player %d's turn", playersTurnNr);
        return turn;
    }

    public String playerWon(final int playersTurnNr)
    {
        String won = String.format("player %d won!", playersTurnNr);
        return won;
    }

    public boolean boardForEachPlayer()
    {
        return this._boardForEachPlayer;
    }

    public boolean winCondition(char[][] board, int row, int col, char marker) {
        int winCounter = 0;

        //VERTICAL
        for (int i = 0; i < col; i += 1)
            for (int k = 0; k < row; k += 1) {
                if (k + 1 < row && board[k][i] != ' ')
                    if (board[k][i] == marker && board[k + 1][i] == marker) {
                        winCounter += 1;
                        if (winCounter == _winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;
        //HORIZONTAL
        for (int i = 0; i < row; i += 1)
            for (int k = 0; k < col; k += 1) {
                if (k + 1 < col && board[i][k] != ' ')
                    if (board[i][k] == marker && board[i][k + 1] == marker) {
                        winCounter += 1;
                        if (winCounter == _winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;

        //HORIZONTAL DOWN RIGHT
        for (int i = 0; i < row; i += 1)
            for (int k = 0; k < col; k += 1) {
                if (k + 1 < col && i + k + 1 < row && board[i + k][k] != ' ')
                    if (board[i + k][k] == marker && board[i + k + 1][k + 1] == marker) {
                        winCounter += 1;
                        if (winCounter == _winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;


        for (int i = 0; i < row; i += 1)
            for (int k = 0; k < col; k += 1) {
                if (k + 1 < col && i + k + 1 < row && board[k][k + i] != ' ')
                    if (board[k][k + i] == marker && board[k + 1][i + k + 1] == marker) {
                        winCounter += 1;
                        if (winCounter == _winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;

        //HORIZONTAL UP RIGHT
        for (int i = row - 1; i >= 0; i -= 1)
            for (int k = 0; k < col; k += 1) {
                if (i - k - 1 >= 0 && k + 1 < col && board[i - k][k] != ' ')
                    if (board[i - k][k] == marker && board[i - k - 1][k + 1] == marker) {
                        winCounter += 1;
                        if (winCounter == _winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;
        
        for (int i = row - 1; i >= 0; i -= 1)
            for (int k = 0; k < col; k += 1) {
                if (row - 2 - k >= 0 && col - i + k < col && board[row - 1 - k][col - 1 - i + k] != ' ')
                    if (board[row - 1 - k][col - 1 - i + k] == marker && board[row - 2 - k][col - i + k] == marker) {
                        winCounter += 1;
                        if (winCounter == _winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }

        return false;
    }
}

