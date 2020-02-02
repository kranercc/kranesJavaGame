package com.github.krane.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	
	public static Tile bushTile = new BushTile(0);
	public static Tile stoneTile = new StoneTile(1);
	
	public static Tile gravelTile = new GravelTile(2);
	
	
	
	
	
	
	//class
	
	public static final int tile_width = 64, tile_height = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public boolean isSold = false;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
	
		tiles[id] = this;
	}
	
	
	public void tick()
	{
		
	}

	public void render(Graphics graphics, int x, int y)
	{
		graphics.drawImage(texture, x, y, tile_width, tile_height, null);
	}
	
	
	public int getId()
	{
		return id;
	}

}
