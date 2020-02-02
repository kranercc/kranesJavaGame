package com.github.krane.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage backgroundFirstVillage;
	
	public static BufferedImage Blue_Slime;
	
	public static void init()
	{
		backgroundFirstVillage = ImageLoader.loadImage("/textures/StartVillageBackground.jpg");
		
		Blue_Slime = ImageLoader.loadImage("/textures/Enemy/Blue_Slime/blue_slime_look_back.png");
	}
}
