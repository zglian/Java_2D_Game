package inputs;

import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;

import gamestates.Gamestate;
import main.GamePanel;

public class Keyboardinputs implements KeyListener{
	
	private GamePanel gamePanel;
	public Keyboardinputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().keyPressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().keyPressed(e);
			break;
		default:
			break;
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().keyRealesed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().keyRealesed(e);
			break;
		default:
			break;
		}
	}
}
