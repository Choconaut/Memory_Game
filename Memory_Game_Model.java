package memorygame;
//This is where methods for the control are stored

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Memory_Game_Model {
	private Memory_Game_Control c;
	Random r = new Random();
	int a = 0;
	int n = 0;
	ArrayList<Integer> memoryPosition = new ArrayList<Integer>();
	
	
	public Memory_Game_Model(Memory_Game_Control fromC) {
		c = fromC;

	}
	
	public void gameStart() {//starts up the game so JButtons are abled to be clicked
		System.out.println("Game Beginning");
		c.start.setEnabled(false);
		c.turns = 0;
		for(int i = 0; i < 36; i ++) {
			memoryPosition.add(i);
		}
		
		
		
		
		for(int i = 0; i < 18; i++) {//randomizes the values of jbuttons and their counterparts
			for(int k = 0; k <2; k++) {//k must be less than 2 because you dont want more than 2 matching buttons
				int j = memoryPosition.get(r.nextInt(memoryPosition.size()));
				 memoryPosition.remove((Integer) j);
				c.memoryBoard[j].setText(String.valueOf(i));
			}
		}
		for(int l = 0; l < c.memoryBoard.length; l++) {//allows user to click jbuttons
			c.memoryBoard[l].setEnabled(true);
		}
	}

	public void checkStatus() {//checks if the user has "beaten" the game
		n = c.memoryBoard.length;
		for(int m = 0; m < c.memoryBoard.length;m++) {//used to test if jbuttons are disabled
			if(c.memoryBoard[m].isEnabled() == false) {
				a++;
				//System.out.println(a); 
			}
		}
		if(a == 36) {
			try {//delays for 1 sec for design reasons
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("You Win");
			c.popupWin();
		}else if(a != 36) {
			a = 0;
			//System.out.println("a is reset");
		}
	}
	
	public void gameReset() {//shows user the answers and disables jbuttons
		System.out.println("Game Reset");
		c.start.setEnabled(true);
		for(int m = 0; m < c.memoryBoard.length; m++) {
			c.memoryBoard[m].setBackground(c.cDGrey);
			c.memoryBoard[m].setEnabled(false);
			c.memoryBoard[m].setForeground(c.cDGrey);
		}
		c.addItems();
	}
	
	public void gamePopup() {
		c.startupMenu.dispose();
		c.popupView();
	}
}
