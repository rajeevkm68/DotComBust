/**
 * This is a Program to Simulate Dot Com Bust Game
 */
package DotComBust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

/**
 * @author rajeevkm
 *
 */

@SuppressWarnings("unused")
public class DotComBust {

		private GameHelper helper = new GameHelper();
		private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
		private int numOfGuesses = 0;

		private void SetUpGame() {

			//First make some dot coms and give them locations

			DotCom one = new DotCom();
			one.SetName("Pets.com");

			DotCom Two = new DotCom();
			Two.SetName("eToys.com");

			DotCom Three = new DotCom();
			Three.SetName("Go2.com");

			dotComList.add(one);
			dotComList.add(Two);
			dotComList.add(Three);

			System.out.println("Your Goal is to sink three dot coms");
			System.out.println("Pet.Com, eToys.com, Go2.com");
			System.out.println("Try to Sink all in the fewest number of Guesses");

			for(DotCom dotComToSet : dotComList) { 

				ArrayList<String> newLocation = helper.placeDotCom(3);
				dotComToSet.SetLocationCells(newLocation);
			}

		}

		private void StartPlaying() {

			while(!dotComList.isEmpty()) {

				String userGuess = helper.getUserInput("Enter a Guess ");
				checkUserGuess(userGuess);
			}
			finishGame();
		}


		private void checkUserGuess(String userGuess) {

			numOfGuesses++;		

			String result = "miss";

			for(int x = 0; x < dotComList.size(); x++) {

				result = dotComList.get(x).checkYourself(userGuess);

				if (result.equals("hit")) {
		
					break;
				}
			
				if (result.equals("kill")) {

					dotComList.remove(x);
					break;

				}
			}

			System.out.println(result);
		}

		private void finishGame() {

			System.out.println("All Dot Coms are dead; Your Stock is now Worthless");
			if (numOfGuesses < 18) {
				System.out.println("It Only took you" + numOfGuesses + "guesses");
				System.out.println("You got out before yoru Option Sank");
			}
			else {
				System.out.println("It Only took you" + numOfGuesses + "guesses");
				System.out.println("Fish are Dancing with your Options");
			}
		}
		
		public static void main(String[] args) {

			DotComBust game = new DotComBust();
			game.SetUpGame();
			game.StartPlaying();
		}
} // End of DotComBust Class

