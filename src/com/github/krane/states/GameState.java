package com.github.krane.states;

import java.awt.Color;
import java.awt.Graphics;

import com.github.krane.Display;
import com.github.krane.Game;
import com.github.krane.entities.Player;
import com.github.krane.gfx.Assets;
import com.github.krane.gfx.ImageLoader;

public class GameState extends State{

	
	private Player player;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
	}
	
	@Override
	public void tick() 
	{
		player.tick();
	}

	@Override
	public void render(Graphics graphics) 
	{
		
		graphics.drawImage(Assets.backgroundFirstVillage, 0,0, 1024, 768, null);
		player.render(graphics);
		
		
		//panel
		int panelCoords[] = {62, 565, 900, 100};
		graphics.drawRect(panelCoords[0], panelCoords[1], panelCoords[2], panelCoords[3]);
		graphics.drawString("Dash Cooldown: " + player.getSpell().remainingTime_DASH , panelCoords[0] + 10, panelCoords[1] + 20);
	}

	
}
