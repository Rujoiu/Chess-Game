package chess;

public class King extends Piece{
    public King(PieceColour colourKing){
        this.colour = colourKing;
        if(this.colour == PieceColour.WHITE){
            this.setSymbol("\u2654");
        }
        else{
            this.setSymbol("\u265A");
        }
    }

    public boolean isLegitMove(int i, int j, int x, int y){
        int movI[] = {0, 0, -1, -1, -1, 1, 1, 1}; // Directions for columns
        int movJ[] = {-1, 1, 0, -1, 1, 0, -1, 1}; // Directions for rows
        for(int a=0; a<8; a++){ // a = the direction
            if(i + movI[a] == x && j + movJ[a] == y){
                if(Board.getBoard()[x][y].hasPiece() == true){
                    if(Board.getBoard()[x][y].getPiece().getColour() == this.colour){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}
