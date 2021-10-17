package chess;

public class Pawn extends Piece {
    public Pawn(PieceColour colourPawn){
        this.colour = colourPawn;
        if(this.colour == PieceColour.WHITE){
            this.setSymbol("\u2659");
        }
        else{
            this.setSymbol("\u265F");
        }
    }

    public boolean isLegitMove(int i, int j, int x, int y){
        Square [][] board = Board.getBoard();
        // Black Pawns
        if(board[i][j].getPiece().getColour() == PieceColour.BLACK){
            // 1 square move
            if(x == (i+1) && (y == j)){
                if(board[i+1][j].hasPiece()){
                    return false;
                }
                else{
                    return true;
                }
            }
            // 2 squares move
            else if (x == (i+2) && (y==j) && (i==1)){
                if (board[i+1][j].hasPiece() || board[i+2][j].hasPiece()){
                    return false;
                }
                else{
                    return true;
                }
            }
            // Diagonal move
            else if (x == (i+1) && (y == j+1)){
                if(board[i+1][j+1].hasPiece()){
                    if (board[i+1][j+1].getPiece().getColour() == PieceColour.WHITE) {
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            // Diagonal move
            else if (x==(i+1) && (y == j-1)){
                if(board[i+1][j-1].hasPiece()){
                    if(board[i+1][j-1].getPiece().getColour() == PieceColour.WHITE){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        // White Pawns
        else{
            // 1 square move
            if(x == (i-1) && (y == j)){
                if(board[x][y].hasPiece()){
                    return false;
                }
                else{
                    return true;
                }
            }
            // 2 squares move
            else if (x == (i-2) && (y==j) && (i==6)){
                if (board[i-1][j].hasPiece() || board[i-2][j].hasPiece()){
                    return false;
                }
                else{
                    return true;
                }
            }
            // Diagonal move
            else if (x == (i-1) && (y == j+1)){
                if(board[i-1][j+1].hasPiece() && board[i-1][j+1].getPiece().getColour() == PieceColour.BLACK){
                    return true;
                }
                else {
                    return false;
                }
            }
            // Diagonal move
            else if (x==(i-1) && (y == j-1)){
                if(board[i-1][j-1].hasPiece() && board[i-1][j-1].getPiece().getColour() == PieceColour.BLACK){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
