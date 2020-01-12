public class Controller {
    private Board _board;
    private Player _player;
    private boolean _gameOver = false;
    private RuleEngine _ruleEngine;
    private View _view[];

    public Controller() {
        _board = new Board(this);
        _player = new Player(this);
        _ruleEngine = new RuleEngine(this);
        if(_ruleEngine.boardForEachPlayer())
        {
            _view = new View[_player.getHowManyPlayers()];
            for(int i = 0; i < _player.getHowManyPlayers(); i += 1)
                _view[i] = new View(this);
        }
        else
        {
            _view = new View[1];
            _view[0] = new View(this);
        }
    }

    public void unitClicked(final int rows, final int cols) {

        int nrOfViews = (_ruleEngine.boardForEachPlayer() ? _player.getHowManyPlayers() : 1);

        if (!_gameOver) {
            if (_ruleEngine.validMove(_board.getBoard(), rows, cols)) {
                _board.drawBoard(rows, cols, _ruleEngine.charMarker(_player.get_playersTurn()));

                for(int i = 0; i < nrOfViews; i += 1)
                    _view[i].setButton(_ruleEngine.stringMarker(_player.get_playersTurn()), rows, cols);

                _gameOver = _ruleEngine.winCondition(_board.getBoard(), _board.getRow(), _board.getCol(), _ruleEngine.charMarker(_player.get_playersTurn()));

                if(_gameOver)
                    for(int i = 0; i < nrOfViews; i += 1)
                        _view[i].playerWin(_ruleEngine.playerWon(_player.get_playersTurn() + 1));
                else
                {
                    _player.nextPlayer();
                    for(int i = 0; i < nrOfViews; i += 1)
                        _view[i].setPlayerTurn(_ruleEngine.playersTurn(_player.get_playersTurn() + 1));
                }
            }
        }
    }
}
