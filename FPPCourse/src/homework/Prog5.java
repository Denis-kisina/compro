package homework;

public class Prog5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String outstring="", topstring="", downstring="", line = "";
		  for (int i=0; i< 8; i++) {
			  
			  topstring += String.format("%4d\t\t",RandomNumbers.getRandomInt(1, 9));
			  downstring += String.format("+%3d\t\t", RandomNumbers.getRandomInt(1, 99));
			  line += "_____\t\t";
			  
			  if(i == 3 || i == 7) {
				outstring += topstring+"\n"+downstring+"\n"+line+"\n\n\n";
				  topstring = ""; 
				  downstring = "";
				  line = "";
			  }
			  
			  }
		  System.out.println(outstring);
		  
		  /*
		   * Sample Output:
		   *   9		   6		   5		   8		
			+ 15		+ 47		+ 77		+ 11		
			_____		_____		_____		_____		
			
			
			   3		   4		   5		   4		
			+ 34		+ 14		+ 58		+ 42		
			_____		_____		_____		_____		

		   * */
	}

}
