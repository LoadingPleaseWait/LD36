package com.github.houkagoteatime.LD36.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 */
public class Player extends Entity{
	public static final int PLAYER_SPEED = 10;
	public Player(int health, int damage, Sprite sprite) {
		super(health, damage, PLAYER_SPEED, sprite);
	}

	/* (non-Javadoc)
	 * @see com.github.houkagoteatime.LD36.entities.Entity#spawn(int, int)
	 */
	@Override
	public void spawn(int xPos, int yPos) {
		super.spawn(xPos, yPos);
		setBounds(new Rectangle(xPos, yPos, sprite.getWidth() - 20, sprite.getHeight() - 20));
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.houkagoteatime.LD36.entities.Entity#rotate(float)
	 */
	@Override
	public void rotate(float degrees) {
		sprite.setRotation(degrees);
	}

	

}
