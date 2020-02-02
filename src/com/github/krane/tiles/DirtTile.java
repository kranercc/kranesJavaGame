package com.github.krane.tiles;

import java.awt.image.BufferedImage;

import com.github.krane.gfx.Assets;

public class DirtTile extends Tile {

	public DirtTile(int id) {
		super(Assets.tile_dirt, id);
		isSold = false;
	}

}
