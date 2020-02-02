package com.github.krane.tiles;

import java.awt.image.BufferedImage;

import com.github.krane.gfx.Assets;

public class GravelTile extends Tile{

	public GravelTile(int id) {
		super(Assets.tile_gravel, id);
		isSold = false;
	}
	
	

}
