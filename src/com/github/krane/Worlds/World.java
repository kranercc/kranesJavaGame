package com.github.krane.Worlds;

import java.awt.Graphics;

import com.github.krane.tiles.Tile;

public class World {

	private int width, height;
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
		width = 5;
		height = 5;
		
		tiles = new int[width][height];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				tiles[x][y] = 1;
				
			}
		}
	}
	
}
