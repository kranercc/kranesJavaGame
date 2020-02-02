package com.github.krane.states;

import java.awt.Color;
import java.awt.Graphics;

import com.github.krane.Display;
import com.github.krane.Game;
import com.github.krane.entities.Player;
import com.github.krane.gfx.AbilityPanel;
import com.github.krane.gfx.Assets;
import com.github.krane.gfx.ExpBar;
import com.github.krane.gfx.ImageLoader;
import com.github.krane.tiles.BushTile;
import com.github.krane.tiles.Tile;

public class GameState extends State{

	private AbilityPanel abilityPanel;
	private ExpBar expBar;
	private Player player;
	
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100, 100);
		abilityPanel = new AbilityPanel();
		expBar = new ExpBar(abilityPanel);
	
	}
	
	@Override
	public void tick() 
	{
		player.tick();
	}

	@Override
	public void render(Graphics graphics) 
	{
		
		
		
		
		player.render(graphics);
		
		abilityPanel.draw(graphics, player);
		expBar.draw(graphics, player);
		
		
		
		
	
		
		
	}

	
}
