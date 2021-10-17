package chess;
import java.io.*;

public class CheckInput {

	public boolean checkCoordinateValidity(String input){
		if(input.matches("[1-8][a-h]")){
			return true;
		}
		else{
			return false;
		}
	}
}
