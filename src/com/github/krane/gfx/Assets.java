package com.github.krane.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage backgroundFirstVillage;
	
	public static void init()
	{
		backgroundFirstVillage = ImageLoader.loadImage("/textures/StartVillageBackground.jpg");
		
	}
}
