package com.github.krane.Worlds;

import java.awt.Graphics;

import com.github.krane.Utils.Utils;
import com.github.krane.entities.Player;
import com.github.krane.tiles.Tile;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	
	
	public World(String path)
	{
		loadWorld(path);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics graphics)
	{
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				getTile(x, y).render(graphics, x * Tile.tile_width, y * Tile.tile_height);
				
				
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
		{
			return Tile.bushTile;
		}
		return t;
	}
	
	private void loadWorld(String path)
	{
		String fileString = Utils.loadFileAsString(path);
		
		String[] tokenStrings = fileString.split("\\s+");
		
		width = Utils.parseInt(tokenStrings[0]);
		height = Utils.parseInt(tokenStrings[1]);
		spawnX = Utils.parseInt(tokenStrings[2]);
		spawnY = Utils.parseInt(tokenStrings[3]);
		
		
		tiles = new int[width][height];
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokenStrings[(x + y * width) + 4]); 
			}
		}
		
		
	}
	
}
