package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	public Game(){
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();
		boolean white = true; // Turn counter
		Console console = System.console();
		CheckInput check = new CheckInput();
		while (!gameEnd){
			if(white){
				System.out.println("\n---- WHITE Moves ----");
			}
			else{
				System.out.println("\n---- BLACK Moves ----");
			}
			System.out.println("> Enter origin: ");
			String origin = console.readLine();
			if(check.checkCoordinateValidity(origin)){	// Checks if the coordinates are valid
				int startX = origin.charAt(0) - '1';
				int startY = origin.charAt(1) - 'a';
				if(b.hasPiece(startX, startY)){
					if(b.getPiece(startX, startY).getColour() == PieceColour.WHITE && white == false){
						System.out.println("Not your piece :(");
						continue;
					}
					else if(b.getPiece(startX, startY).getColour() == PieceColour.BLACK && white == true){
						System.out.println("Not your piece :(");
						continue;
					}
					String dest = console.readLine("> Enter destination:\n");
					if(check.checkCoordinateValidity(origin)){	// Checks if the coordinates are valid
						int finalX = dest.charAt(0) - '1';
						int finalY = dest.charAt(1) - 'a';
						if(b.getPiece(startX, startY).isLegitMove(startX, startY, finalX, finalY)){
							gameEnd = b.movePiece(startX, startY, finalX, finalY, b.getPiece(startX, startY));
							b.printBoard();
							white = !white;
						}
						else{
							System.out.println("Impossible move");
						}
					}
					else if (dest.equals("END")){	// END = Resign
						if(white){
							System.out.println("White resigned!");
						}
						else{
							System.out.println("Black resigned!");
						}
						gameEnd = true;
						continue;
					}
					else{
						System.out.println("Invalid coordinates");
					}
				}
				else{
					System.out.println("No Piece There");
				}
			}
			else{
				if(origin.equals("END")){
					if(white){
						System.out.println("White resigned!");
					}
					else{
						System.out.println("Black resigned!");
					}
					gameEnd = true;
					continue;
				}
				else{
					System.out.println("Invalid coordinates");
				}
			}
			if(gameEnd){
				b.printBoard();
				if(!white){
					System.out.println("\nWhite won!");
				}
				else{
					System.out.println("\nBlack won!");
				}
			}

		}
	}


	public static void main (String args[]){
		Game g  = new Game();
	}
}
