package com.github.krane.tiles;

import java.awt.image.BufferedImage;

import com.github.krane.gfx.Assets;

public class BushTile extends Tile{

	public BushTile(int id) {
		super(Assets.Tile_Bush, id);
		isSold = true;
	}

	
}
