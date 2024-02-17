package memorygame;
/*This is where the GUI is made

*/
import java.awt.*;
import javax.swing.*;

public class Memory_Game_View extends JFrame{
	public JFrame winner, gameFrame, startupMenu;
	public JButton[] memoryBoard = new JButton[36];
	public JButton start, reset, begin, createGame, credits, options, exit;
	public JLabel timerLabel, counterLabel, statusLabel, titleLabel;
	public JPanel gameArea, textArea, buttonArea, timerArea, optionsArea, titleArea;
	public Color cDGrey = new Color(50,50,50);
	public Color cLGrey = new Color(75,75,80);
	public JTextArea outArea = new JTextArea(60,60);
	
	public static void main(String args[]) {
		new Memory_Game_View();
	}
	
	public Memory_Game_View() {
		//Declares objects so that they can be used
		winner = new JFrame();
		gameFrame = new JFrame();
		startupMenu = new JFrame();
		gameArea = new JPanel();
		textArea = new JPanel();
		buttonArea = new JPanel();
		timerArea = new JPanel();
		optionsArea = new JPanel();
		titleArea = new JPanel();
		start = new JButton("Start");
		reset = new JButton("Reset");
		begin = new JButton("Begin");
		options = new JButton("Options");
		credits = new JButton("Credits");
		exit = new JButton("Exit");
		createGame = new JButton("Play");
		timerLabel = new JLabel("Turns:");
		statusLabel = new JLabel("YOU WIN!");
		counterLabel = new JLabel();
		titleLabel = new JLabel("Memory Game", SwingConstants.CENTER);
		
		colorsAndFonts();
		
		titleArea.setBounds(5, 5, 225, 75);
		titleArea.setLayout(new BorderLayout());
		titleArea.add(titleLabel);
		optionsArea.setBounds(5,105,225,150);
		optionsArea.setLayout(new GridLayout(4, 1, 0, 5));
		optionsArea.add(createGame);
		optionsArea.add(options);
		optionsArea.add(credits);
		optionsArea.add(exit);
		
		startupMenu.add(titleArea, BorderLayout.NORTH);
		startupMenu.add(optionsArea, BorderLayout.CENTER);
		
		startupMenu.setLayout(new BorderLayout());
		startupMenu.setTitle("Memory Game Menu");
		startupMenu.setBounds(5,5, 250, 325);
		startupMenu.setVisible(true);
	}
	
	public void colorsAndFonts() {
		outArea.setForeground(Color.WHITE);
		outArea.setBackground(cLGrey);
		textArea.setBackground(cLGrey);
		gameArea.setBackground(cLGrey);
		buttonArea.setBackground(cLGrey);
		timerArea.setBackground(cLGrey);
		titleArea.setBackground(cLGrey);
		titleArea.setForeground(Color.WHITE);
		optionsArea.setForeground(Color.WHITE);
		optionsArea.setBackground(cLGrey);
		start.setForeground(Color.WHITE);
		start.setBackground(cLGrey);
		reset.setForeground(Color.WHITE);
		reset.setBackground(cLGrey);
		timerLabel.setForeground(Color.WHITE);
		counterLabel.setForeground(Color.WHITE);
		statusLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Univers", Font.BOLD, 15));
		titleLabel.setForeground(Color.WHITE);
		
		gameFrame.getContentPane().setBackground(cDGrey);
		startupMenu.getContentPane().setBackground(cDGrey);
	}
	
	public void popupView() {//pops up the game window if begin is selected
		gameArea.setBounds(5, 5, 490, 400);
		gameArea.setLayout(new GridLayout(4,4,0,0));
		textArea.setBounds(5,415,245,125);
		textArea.setLayout(new GridLayout(2,1,0,0));
		buttonArea.setBounds(255,415,240,125);
		buttonArea.setLayout(new GridLayout(3,1,0,0));
		gameFrame.add(gameArea,BorderLayout.NORTH);
		gameFrame.add(textArea,BorderLayout.CENTER);
		gameFrame.add(buttonArea,BorderLayout.CENTER);
		for(int i=0; i < memoryBoard.length; i++) {
			memoryBoard[i] = new JButton(String.valueOf(""));
			memoryBoard[i].setForeground(cDGrey);
			memoryBoard[i].setBackground(cDGrey);
			gameArea.add(memoryBoard[i]);
		}
		addItems();
		textArea.add(outArea);
		buttonArea.add(start);
		buttonArea.add(reset);
		buttonArea.add(timerArea);
		timerArea.add(timerLabel);
		timerArea.add(counterLabel);
		gameFrame.setLayout(new BorderLayout());
		gameFrame.setTitle("Memory Game");
		gameFrame.setBounds(5,5,515,585);
		gameFrame.setVisible(true);
	}
	
	public void popupWin() {//pops up a window if you win
		winner.getContentPane().setBackground(cDGrey);
		winner.add(statusLabel);
		winner.setTitle("Memory Game");
		winner.setBounds(5, 5, 100, 100);
		winner.setVisible(true);
	}
	
	public void addItems() {
		outArea.append("Welcome to the Memory Game! \n");
		outArea.append("The game will begin after you click start. \n");
		outArea.append("Try to finish the game in the least amount \n");
		outArea.append("of turns as possible! Good Luck!");
		outArea.setEditable(false);
	}
	
}
