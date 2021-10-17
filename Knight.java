package chess;

public class Knight extends Piece{
    public Knight(PieceColour colourKnight){
        this.colour = colourKnight;
        if(this.colour == PieceColour.WHITE){
            this.setSymbol("\u2658");
        }
        else{
            this.setSymbol("\u265E");
        }
    }

    public boolean isLegitMove(int i, int j, int x, int y){
        int movI[] = {-2, -2, -1, -1, 1, 1, 2, 2};  // Directions for columns
        int movJ[] = {-1, 1, -2, 2, -2, 2, -1, 1};  // Directions for rows
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
