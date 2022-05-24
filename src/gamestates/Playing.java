package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import main.Game;
import ui.PauseOverlay;

public class Playing extends State implements Statemethods{
	private Player player;
	private PauseOverlay pauseOverlay;
	private boolean paused = true;
	
	
	public Playing(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		initClasses();
	}
	
	private void initClasses() {
		// TODO Auto-generated method stub
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		pauseOverlay = new PauseOverlay();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.update();
		pauseOverlay.update();
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		player.render(g);
		pauseOverlay.draw(g);
	}
 
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON1)
			player.setAttacking(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(paused)
			pauseOverlay.mousePressed(e);
	}

	@Override
	public void mouseRealesed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(paused)
			pauseOverlay.mouseRealesed(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(paused)
			pauseOverlay.mouseMoved(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_S:
			player.setDown(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
					break;
		case KeyEvent.VK_ESCAPE:
			Gamestate.state = Gamestate.MENU;
		}
		
	}

	@Override
	public void keyRealesed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(false);
			break;
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_S:
			player.setDown(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
					break;
		}
	}
	
	public void windowFocusLost() {
		player.resetDirBooleans();
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
