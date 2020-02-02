package com.github.krane.entities;

import java.awt.Graphics;

import com.github.krane.Game;
import com.github.krane.helpers.TimeHelp;
import com.github.krane.input.KeyManager;
import com.github.krane.playerSpecific.LevelingUP;
import com.github.krane.spells.Spells;

public class Player extends Creature{

	private Game game;
	private Spells spells;
	private LevelingUP levelingUP;
	
	public int str, agi, intel, level, exp, requiredExp, passiveXP_Ammount;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.default_creature_width, Creature.default_creature_width);
		this.game = game;
		
		spells = new Spells();
		levelingUP = new LevelingUP();
		
		str = 15;
		agi = 10;
		intel = 7;
		

		level = 1;
		
		speed =  default_speed + agi*0.08f;
		health = default_health + str*0.30f;
		maxHealth = health;
		
		exp = 1;
		requiredExp = 250;
		passiveXP_Ammount = 10;
		
		
	}

//	public void levelUP()
//	{
//		str++;
//		agi++;
//		intel++;
//		level++;
//		speed = default_speed + agi*0.05f;
//	}
	
	@Override
	public void tick() {
		
		levelingUP.passiveExperience(this);
		levelingUP.levelUp(this);
		
		checkBounderies();

		spells.Dash(this);
		spells.Regen(this);
		
		
		System.out.println(health + "<>"+ maxHealth);
		
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
			exp+=10;
			x += speed;
		}
		
		
	}

	public Game getGame() {
		return game;
	}

	@Override
	public void render(Graphics graphics) {
		
		graphics.fillRect( (int)x, (int)y, width, height);
		
	}

	
	public Spells getSpell()
	{
		return spells;
	}
	
	public void checkBounderies()
	{
		if (x > 1024 - width)
		{
			x = 1024 - width;
		}
		if (y > 768 - height)
		{
			y = 768 - height;
		}
		if (x < 0)
		{
			x = 0;
		}
		if (y < 0)
		{
			y = 0;
		}
		
	}
	
	
	
}
