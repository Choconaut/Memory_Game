package memorygame;
//

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


public class Memory_Game_Control extends Memory_Game_View implements ActionListener{
	JButton buttonPressed;
	String button1, button2;
	int a,b, turns;
	
	public Memory_Game_Model m;
	
	public static void main(String args[]) {
		new Memory_Game_Control();
	}
	
	public Memory_Game_Control() {
		m = new Memory_Game_Model(this);
		start.addActionListener(this);
		createGame.addActionListener(this);
		reset.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton selButton = (JButton) e.getSource();
		if(selButton == createGame) {
			m.gamePopup();
			for (int i = 0; i < memoryBoard.length; i++) {
				memoryBoard[i].addActionListener(this);
				memoryBoard[i].setEnabled(false);
			}
			this.repaint();
		}
		if(selButton == start) {
			m.gameStart();
			this.repaint();
		}else if (selButton == reset) {
			m.gameReset();
			this.repaint();
		}
		for(int j = 0; j < memoryBoard.length; j++) {
			if (selButton == memoryBoard[j]) {
				memoryBoard[j].setForeground(Color.WHITE);
				buttonPressed = selButton;
				if(button1 == null) {
					a = j;
					button1 = buttonPressed.getText();
					memoryBoard[a].setEnabled(false);//prevents user from clicking same button twice
					System.out.println("button1: " + button1);
				}else if(button2 ==null){
					b=j;
					button2 = buttonPressed.getText();
					System.out.println("button2: " + button2);
				}
				
				
				if(button1 != null && button2 != null) {
					System.out.println("Checking...");
					turns++;
					counterLabel.setText(String.valueOf(turns));
					if(button1.equals(button2)) {//disables buttons if the values match
						memoryBoard[a].setEnabled(false);
						memoryBoard[b].setEnabled(false);
						memoryBoard[a].setBackground(Color.WHITE);
						memoryBoard[b].setBackground(Color.WHITE);
						button1 = null;
						button2 = null;
						m.checkStatus();
					}else if(button1 != button2){//resets buttons if the values dont match
						try {//delays so user has time to memorize/see choices
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						memoryBoard[a].setForeground(cDGrey);
						memoryBoard[b].setForeground(cDGrey);
						memoryBoard[a].setEnabled(true);
						button1 = null;
						button2 = null;
					}
				}
			}
		}
	}
}
	
