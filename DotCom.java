package DotComBust;

import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String> locationCells;
	private String name;

	public void SetLocationCells(ArrayList<String> loc) {

		locationCells = loc;

	}

	public void SetName(String n) {

		name = n;

	}	


	public String checkYourself(String userInput) {

		String result = "miss";
		int index = locationCells.indexOf(userInput);

		if (index >= 0) {
	
			locationCells.remove(index);
	
			if(locationCells.isEmpty()) {
		
				result = "miss";
				System.out.println("Ouch: You Sunk " + name + "  : ");

			} else {

				result = "hit";
        	        }
                }  
		return(result);
	}
}

