package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestates.Gamestate;
import main.GamePanel;

import static utilz.Constants.PlayerConstants.*;

public class MouseInputs implements MouseListener, MouseMotionListener{
	
	private GamePanel gamePanel;
	
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case PLAYING:
			gamePanel.getGame().getPlaying().mouseDragged(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mouseMoved(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying ().mouseMoved(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case PLAYING:
			gamePanel.getGame().getPlaying ().mouseClicked(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mousePressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying ().mousePressed(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mouseRealesed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying ().mouseRealesed(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
