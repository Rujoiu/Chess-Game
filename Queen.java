package chess;

public class Queen extends Piece{
    public Queen(PieceColour colourQueen){
        this.colour = colourQueen;
        if(this.colour == PieceColour.WHITE){
            this.setSymbol("\u2655");
        }
        else{
            this.setSymbol("\u265B");
        }
    }
    public boolean isLegitMove(int i, int j, int x, int y){
        int movI[] = {0, 0, -1, -1, -1, 1, 1, 1}; // Directions for columns
        int movJ[] = {-1, 1, 0, -1, 1, 0, -1, 1}; // Directions for rows
        for(int a=0; a<8; a++){ // a = the direction
            int newX = i;
            int newY = j;
            while (true){
                newX = newX + movI[a];
                newY = newY + movJ[a];
                if(newX>7 || newY>7 || newX<0 || newY<0){
                    break;
                }
                if(Board.getBoard()[newX][newY].hasPiece() == true){
                    if(Board.getBoard()[newX][newY].getPiece().getColour() == this.colour){
                        break;
                    }
                    else{
                        if (newX == x && newY == y){
                            return true;
                        }
                        else{
                            break;
                        }
                    }
                }
                if(newX == x && newY == y){
                    return true;
                }
            }
        }
        return false;
    }
}
