package chess;


//This class is partially implemented 
public class Square {
	private int i;
	private int j;
	private boolean hasPiece = false;
	private Piece p;

	
	public Square(int iIn, int jIn){
		i=iIn;
		j=jIn;
	}
	
	public Piece getPiece(){
		return this.p;
	}

	public void setPiece(Piece piece){
		this.p = piece;
		hasPiece = true;
	}

	public void removePiece(){
		this.p = null;
		hasPiece = false;
	}

	public boolean hasPiece(){
		return hasPiece;
	}

	public int getI(){
		return i;
	}

	public int getJ(){
		return j;
	}
}
