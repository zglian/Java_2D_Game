package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Statemethods {
	public void update();
	public void draw(Graphics g);
	public void mouseClicked(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseRealesed(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void keyPressed(KeyEvent e);
	public void keyRealesed(KeyEvent e);
	
}