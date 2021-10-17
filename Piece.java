package chess;

abstract class Piece {
    int row;
    int col;
    String symbol;
    protected PieceColour colour;
    public Piece(){
    }
    public String getSymbol(){
        return symbol;
    }
    public void setSymbol(String newsymbol){
        symbol = newsymbol;
    }
    public PieceColour getColour(){
        return colour;
    }
    public void updateCoordinates(int i, int j){
        row = i;
        col = j;
    }

    abstract boolean isLegitMove(int i, int j, int x, int y);
}
