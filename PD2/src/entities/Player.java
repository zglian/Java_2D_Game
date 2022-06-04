package entities;

import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.CanMoveHere;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity{
 
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, anispeed = 25;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;
	private boolean left, up, right, down;
	private float playerSpeed = 2.0f;
	private int[][] lvlData;
	
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		loadAnimation();
		
	}
	
	public void update() {
		updatePos();
		updateHitbox();
		updateAnimeationTick();
		setAniamtion();
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, width, height, null);
		drawHitbox(g);
	}
	
	
	private void updateAnimeationTick() {
		// TODO Auto-generated method stub
		aniTick ++;
		if(aniTick >= anispeed) { 
			aniTick = 0;
			aniIndex ++;
			if(aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
				attacking = false;
			}
		}
	}
	
	private void setAniamtion() {
		// TODO Auto-generated method stub
		
		int startAni = playerAction;
		
		if(moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
		
		if(attacking) 
			playerAction = ATTACK_1;
	
		
		if(startAni != playerAction)
			resetAniTick();
			
		
	}
	
	private void resetAniTick() {
		// TODO Auto-generated method stub
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos() {
		
		moving = false;
		if(!left && !right && !up && !down)
			return;
		
		float xSpeed = 0, ySpeed = 0;
		
		if(left && !right) 
			xSpeed = (-playerSpeed);
		
		else if (right && !left)
			xSpeed = playerSpeed;
			
		if (up && !down) 
			ySpeed = (-playerSpeed);
			
		else if(down && !up) 
			ySpeed = playerSpeed;
		
		if(CanMoveHere(x+xSpeed, y+ySpeed, width, height, lvlData)) {
			this.x += xSpeed;
			this.y += ySpeed;
			moving = true;
		}
	}
	
	private void loadAnimation() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			BufferedImage img = ImageIO.read(is);
			animations = new BufferedImage[9][6];
			
			for(int j = 0 ; j < animations.length ; j ++) {
				for(int i = 0 ; i < animations[j].length ; i ++) {
					animations[j][i] = img.getSubimage( i * 64, j * 40, 64, 40);
					}
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadLvlData(int [][] lvlData) {
		this.lvlData = lvlData;
	}
	
	public void resetDirBooleans() {
		// TODO Auto-generated method stub
		left = false;
		right = false;
		up = false;
		down = false;
	}
	
	public void setAttacking (boolean attacking) {
		this.attacking = attacking;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	

}
