package com.github.krane.entities;

import java.awt.Graphics;

import com.github.krane.Game;
import com.github.krane.helpers.TimeHelp;
import com.github.krane.input.KeyManager;
import com.github.krane.spells.Spells;

public class Player extends Creature{

	private Game game;
	private Spells spells;
	
	private int str, agi, intel, level;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.default_creature_width, Creature.default_creature_width);
		this.game = game;
	
		spells = new Spells();
		str = 15;
		agi = 10;
		intel = 7;
		
		level = 1;
		speed =  default_speed + agi*0.05f;
		
		
	}

	public void levelUP()
	{
		str++;
		agi++;
		intel++;
		level++;
		speed = default_speed + agi*0.05f;
	}
	
	@Override
	public void tick() {
		
		x = spells.DashX(x, agi, game.getKeyManager());
		y = spells.DashY(y, agi, game.getKeyManager());
		
		//System.out.println(speed);
		if(game.getKeyManager().up)
		{
			y -= speed;
		}
		if(game.getKeyManager().down)
		{
			y += speed;
		}
		if(game.getKeyManager().left)
		{
			x -= speed;
		}
		if(game.getKeyManager().right)
		{
			x += speed;
		}
		
	}

	@Override
	public void render(Graphics graphics) {
		
		graphics.fillRect( (int)x, (int)y, width, height);
		
	}

	
	public Spells getSpell()
	{
		return spells;
	}
	
	
	
	
}
