package com.github.krane.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage backgroundFirstVillage;
	
	
	public static BufferedImage Tile_Bush, tile_Black_Hammered_Stone, tile_dirt, tile_gravel;

	
	
	public static BufferedImage Blue_Slime;
	
	
	public static void init()
	{
		backgroundFirstVillage = ImageLoader.loadImage("/textures/StartVillageBackground.jpg");
		
		
		tile_Black_Hammered_Stone = ImageLoader.loadImage("/textures/World_Tiles/black_hammered_stone.jpg");
		Tile_Bush = ImageLoader.loadImage("/textures/World_Tiles/bush.jpg");
		tile_dirt = ImageLoader.loadImage("/textures/World_Tiles/dirtTile.png");
		tile_gravel = ImageLoader.loadImage("/textures/World_Tiles/gravelTile.png");
		
		
		
		Blue_Slime = ImageLoader.loadImage("/textures/Enemy/Blue_Slime/blue_slime_look_back.png");
		
		
	}
}
