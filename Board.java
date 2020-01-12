public class Board
{
    private char[][] _theBoard;
    private Controller _controller;
    private int _row = 5, _col = 5;

    public Board(Controller controller)
    {
        this._controller = controller;
        _theBoard = new char[_row][_col];
        for(int i=0; i < _row; i += 1)
            for(int k = 0; k < _col; k += 1)
            {
                _theBoard[i][k] = ' ';
            }
    }

    public void drawBoard(final int row, final int col, char marker)
    {
        _theBoard[row][col] = marker;
    }

    public char[][] getBoard()
    {
        return this._theBoard;
    }

    public int getRow()
    {
        return this._row;
    }
    public int getCol()
    {
        return this._col;
    }

}

