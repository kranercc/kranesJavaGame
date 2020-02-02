package com.github.krane;

import com.github.krane.Worlds.World;
import com.github.krane.input.KeyManager;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}

	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	public int getHeight()
	{
		return game.getWidth();
	}
	
	
	//getters setters
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	
}
