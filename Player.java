public class Player
{
    private int _playersTurn;
    private int _nrOfPlayers = 2;
    private Controller _controller;

    public Player(Controller controller)
    {
        this._controller = controller;
        _playersTurn = 0;
    }

    public void nextPlayer()
    {
        _playersTurn += 1;
    }

    public int get_playersTurn()
    {
        return _playersTurn % _nrOfPlayers;
    }

    public int getHowManyPlayers()
    {
        return _nrOfPlayers;
    }
}
